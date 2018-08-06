package com.farukgenc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.domain.User;
import com.farukgenc.exception.UserNotFoundException;
import com.farukgenc.repository.UserRepository;
import com.farukgenc.web.resources.SuccessResource;
import com.farukgenc.web.resources.UserResource;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * POST->User create method
	 * 
	 * @param resource
	 * @return
	 */
	@Transactional
	public User create(UserResource resource) {
		User user = new User();
		user.setLastName(resource.getLastName());
		user.setUserName(resource.getUserName());
		return userRepository.save(user);

	}

	@Transactional
	public User update(UserResource resource) throws UserNotFoundException {
		Optional<User> tempUser = userRepository.findById(resource.getObjId());
		if (tempUser.isPresent()) {
			tempUser.get().setUserName(resource.getUserName());
			tempUser.get().setLastName(resource.getLastName());
			return userRepository.save(tempUser.get());

		} else {
			throw new UserNotFoundException("user_bot_found", "usert yoqqq jurgbann");
		}

	}

	public User load(Long objId) {
		return userRepository.findById(objId).get();

	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public SuccessResource remove(Long objId) throws UserNotFoundException {
		Optional<User> tempUser = userRepository.findById(objId);
		if (tempUser.isPresent()) {
			userRepository.deleteById(objId);
			SuccessResource resource = new SuccessResource();
			resource.setCode("204");
			resource.setDesc("Basarılı");
			return resource;
		} else {

			throw new UserNotFoundException("user_not_fn", "dasdas");
		}

	}

}
