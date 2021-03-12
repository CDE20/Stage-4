package com.example.microservices.spring.learn.springLearnuser;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.microservices.spring.learn.springLearnuser.exception.UserNotFoundException;
import com.example.microservices.spring.learn.springLearnuser.user.User;
import com.example.microservices.spring.learn.springLearnuser.user.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getAllUsers(@PathVariable int id) throws UserNotFoundException{
		User u = service.findById(id);
		if(u==null) {
			throw new UserNotFoundException("User not Present");
		}
		return u;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		User u =service.save(user);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/users/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUsers(@PathVariable int id) throws UserNotFoundException{
		User u = service.deleteById(id);
		if(u==null) {
			throw new UserNotFoundException("User not Present");
		}
		return u;
	}

}
