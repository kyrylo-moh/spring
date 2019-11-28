package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserUpdateException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User getUserByNickName(String nickName) {
        return userRepository.findUserByNickName(nickName);
    }

    public User saveUser(UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDTO.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        userDTO.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        User user = new User(userDTO.getEmail(), userDTO.getPassword(), userDTO.getNickName(), userDTO.getLastName(), userDTO.getActive(), userDTO.getRoles());
        return userRepository.save(user);
    }

    public User update(UserDTO userDTO) throws Exception {
        if (userRepository.findById(userDTO.getId()).isPresent()) {
            User user = userRepository.findUserById(userDTO.getId());
            user.setNickName(userDTO.getNickName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setActive(userDTO.getActive());
            user.setRoles(userDTO.getRoles());
            return userRepository.save(user);
        }
        logger.warn("Can not update user - " + userDTO.toString());
        throw new UserUpdateException(
                "Can not update user - " + userDTO.toString());
    }



}
