package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
	
	@Autowired
	private IUserRepo repo;
	
	@GetMapping("/user")
	public List<User> index() {
		return repo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id)
	{
		Optional<User> user = repo.findById(id);

		return user.get();
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUsert(@RequestBody User user) {
		User savedUser = repo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getIdUser()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable int id) {

		Optional<User> userOptional = repo.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setIdUser(id);
		
		repo.save(user);

		return ResponseEntity.noContent().build();
	}

	
	
}
