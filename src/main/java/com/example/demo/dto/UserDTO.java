package com.example.demo.dto;

import com.example.demo.model.Role;

import javax.persistence.*;
import java.util.Set;

public class UserDTO {

    private long id;
    private String email;
    private String password;
    private String nickName;
    private String lastName;
    private int active;
    private Set<Role> roles;

    public UserDTO() {}

    public UserDTO(String email, String password, String nickName, String lastName, int active, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.lastName = lastName;
        this.active = active;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }
}
