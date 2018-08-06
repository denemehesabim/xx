package com.farukgenc.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.domain.User;
import com.farukgenc.web.controller.UserController;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

	public UserResourceAssembler() {
		super(UserController.class, UserResource.class);
	}

	@Override
	public UserResource toResource(User user) {
		UserResource resource = new UserResource();
		resource.setObjId(user.getId());
		resource.setLastName(user.getLastName());
		resource.setUserName(user.getUserName());
		return resource;
	}

}
