package com.farukgenc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.exception.UserNotFoundException;
import com.farukgenc.service.UserService;
import com.farukgenc.web.resources.SuccessResource;
import com.farukgenc.web.resources.UserResource;
import com.farukgenc.web.resources.UserResourceAssembler;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	private final UserResourceAssembler userResourceAssembler;

	@Autowired
	public UserController(UserService userService, UserResourceAssembler userResourceAssembler) {
		this.userService = userService;
		this.userResourceAssembler = userResourceAssembler;
	}

	@PostMapping
	public ResponseEntity<UserResource> create(@RequestBody UserResource resource) {
		return ResponseEntity.ok().body(userResourceAssembler.toResource(userService.create(resource)));

	}

	@PutMapping
	public ResponseEntity<UserResource> update(@RequestBody UserResource resource) throws UserNotFoundException {
		return ResponseEntity.ok().body(userResourceAssembler.toResource(userService.update(resource)));

	}

	@GetMapping("/{objId}")
	public ResponseEntity<UserResource> load(@PathVariable Long objId) throws UserNotFoundException {
		return ResponseEntity.ok().body(userResourceAssembler.toResource(userService.load(objId)));

	}

	@GetMapping
	public ResponseEntity<List<UserResource>> findAll() {
		return ResponseEntity.ok().body(userResourceAssembler.toResources(userService.findAll()));

	}

	@DeleteMapping("/{objId}")
	public ResponseEntity<SuccessResource> delete(@PathVariable Long objId) throws UserNotFoundException {
		return ResponseEntity.ok().body(userService.remove(objId));

	}

}
