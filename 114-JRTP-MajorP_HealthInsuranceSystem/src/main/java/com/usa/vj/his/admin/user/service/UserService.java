package com.usa.vj.his.admin.user.service;

import java.util.List;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.admin.user.model.UnlockUser;
import com.usa.vj.his.admin.user.model.UserModel;

public interface UserService {


	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean insertNewUser(UserModel user);

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean getUserByEmail(String email);

	/**
	 * 
	 * @param unlock
	 * @return
	 */
	public boolean validateTempPwd(UnlockUser unlock);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public boolean accountUnlockedOrNot(UserEntity entity);

	/**
	 * 
	 * @param login
	 * @return
	 */
//	public UserEntity validateLoginCredentials(Login login);

	/**
	 * 
	 * @param registeredEmail
	 */
	public void sendPasswordTo(String registeredEmail);
	
	/**
	 * Get all Users.
	 * @return
	 */
	public List<UserModel> getAllUsers(String role);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserModel getUserById(Integer userId);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserEntity softDeleteUser(Integer userId);
}
