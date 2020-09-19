package com.usa.vj.his.admin.user.service;

import static com.usa.vj.his.app.constants.AdminUserConstants.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.admin.user.model.UnlockUser;
import com.usa.vj.his.admin.user.model.UserModel;
import com.usa.vj.his.admin.user.repo.UserRepository;
import com.usa.vj.his.admin.user.utils.EmailUtil;
import com.usa.vj.his.admin.user.utils.RandomPasswordUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public boolean insertNewUser(UserModel user) {
		//set account status to LOCKED using UserManagemetConstants(C)
		user.setActiveStatus(USER_ACCOUNT_STATUS_INACTIVE);
		//set Delete switch to NO
		user.setDeleteSwitch(DELETE_SWITCH_NO);
		//set random / temp password by using RandomPasswordUtil(C)
		user.setUserPassword(RandomPasswordUtil.generatePassword(TEMPORARY_PASSWORD_LENGTH));
		//Send an email with the Temp password and Unlock link
		emailUtil.sendEmail(user.getUserEmail(), user);
		//new User Entity obj
		UserEntity entity = new UserEntity();
		//convert Binding obj to Entity
		BeanUtils.copyProperties(user, entity);
		if (userRepo.save(entity).getUserId() != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean getUserByEmail(String email) {
		UserEntity userEntity = userRepo.findByUserEmail(email);
		if (userEntity != null)
			return true;
		else
			return false;
	}

	/**
	 > Here save method works as polymorphic method to update the 
	   record with new Account status : UNLOCKED
	 */
	@Override
	public boolean validateTempPwd(UnlockUser user) {
		//getUserByPassword using temp password
		UserEntity userToUnlock = userRepo.findByUserPassword(user.getTempPazzword());

		if (userToUnlock != null) {
			//set account status to Unlocked & update with new password
			userToUnlock.setActiveStatus(USER_ACCOUNT_UNLOCKED);
			userToUnlock.setUserPassword(user.getConfirmPazzword());
			//update the same User enitity with new Account Status : Unlocked
			UserEntity updatedUser = userRepo.save(userToUnlock);
			if (updatedUser.getActiveStatus().equalsIgnoreCase(USER_ACCOUNT_UNLOCKED))
				return true;
		}
		return false;
	}


	/**
	 * check wheather user account is unlocked or not
	 */
	@Override
	public boolean accountUnlockedOrNot(UserEntity entity) {
		if (entity.getActiveStatus().equalsIgnoreCase(USER_ACCOUNT_LOCKED))
			return false;
		else
			return true;
	}

	/**
	 * 
	 */
	@Override
	public void sendPasswordTo(String registeredEmail) {
		UserEntity foundUser = userRepo.findByUserEmail(registeredEmail);
		UserModel user = new UserModel();
		BeanUtils.copyProperties(foundUser, user);
		emailUtil.sendEmail(foundUser.getUserEmail(), user);
	}

	@Override
	public List<UserModel> getAllUsers(String role) {

		//Get List of Contact Entities
		List<UserEntity> entityList = userRepo.findByUserRole(role);
		//java 8 approach
		return entityList.stream().map(entity -> {
			//empty Binding object
			UserModel model = new UserModel();
			//copy Entity to Binding obj
			BeanUtils.copyProperties(entity, model);
			//return contact
			return model;
		}).collect(Collectors.toList());
	}

	/**
	 * use repo to get contact by id
	 */
	@Override
	public UserModel getUserById(Integer userId) {

		Optional<UserEntity> userById = userRepo.findById(userId);

		if (userById.isPresent()) {
			//convert UserEntity to UserModel
			UserModel model = new UserModel();
			//get entity
			UserEntity entity = userById.get();
			//copy entity to binding obj
			BeanUtils.copyProperties(entity, model);
			//return model
			return model;
		}
		return null;
	}

	/**
	 * Delete user by id
	 */
	@Override
	public UserEntity softDeleteUser(Integer userId) {
		//			find user by Id
		Optional<UserEntity> userEntity = userRepo.findById(userId);
		if (userEntity.isPresent()) {
			UserEntity entityToSoftDelete = userEntity.get();
			if (entityToSoftDelete.getDeleteSwitch().contentEquals(DELETE_SWITCH_NO))
				entityToSoftDelete.setDeleteSwitch(DELETE_SWITCH_YES);
			else
				entityToSoftDelete.setDeleteSwitch(DELETE_SWITCH_NO);
			userRepo.save(entityToSoftDelete);
			return userEntity.get();
		}
		return null;
	}

}//end of class
