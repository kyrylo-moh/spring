# spring
Movies API spring/hibernate

Create APIs for users who need to watch a movie. 
They will be provided with a convenient search and a large catalog for review.

Entity:
	Users: 
    id,
    nickName,
    surname,
    email,
    password,
    role_id
    
  Role:
  role_id,
  role_name
    
		
	Movie:
		Name,
		Quality,
		Original Name,
		Tags(scream, comedy etc),
		Year,
		Duration,
		Rate,
		Description,
		image(movie),
		link(movie)

Functional:
	Users:
		nonaut: check movies catalog and movies descriptions
		aut:nonaut + can rate movie
		admin: add movie
	Find:
		- by nameMovie
		- by Author
		- by Year
		- by Genre
		- by Time
		- by Rate
		- unique search
