package com.usa.vj.his.app.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.admin.user.repo.UserRepository;
import com.usa.vj.his.app.login.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepo;

	/**
	 * Authenticating Login user details by Email and Password from Login Binding obj
	 */
	@Override
	public UserEntity validateLoginCredentials(Login login) {
		//user repo 
		UserEntity userFound = userRepo.findByUserEmailAndUserPassword(login.getUserEmail(), login.getUserPassword());
		if (userFound != null)
			return userFound;
		else
			return null;
	}

	/**
	 * check wheather user account is unlocked or not
	 */
	@Override
	public boolean accountUnlockedOrNot(UserEntity entity) {
		if (entity.getActiveStatus().equalsIgnoreCase("locked"))
			return false;
		else
			return true;
	}

	@Override
	public boolean accountActiveOrNot(UserEntity entity) {
		if (entity.getDeleteSwitch().equalsIgnoreCase("N"))
			return true;
		else
			return false;
	}

}
