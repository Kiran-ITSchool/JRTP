package com.usa.vj.his.app.constants;

public interface AdminUserConstants {

	public static final String USER_MODEL_NAME = "UserModel";

	public static final String UNLOCK_MODEL_NAME = "unlockModel";

	public static final String USER_REGISTRATION_LVN = "HisUserReg";
	
	public static final String USER_EDIT_LVN = "HisUserEdit";

	public static final String UNLOCK_USER_LVN = "unlockUser";

	public static final String DISPLAY_ALL_USERS_LVN = "DisplayAllUsers";
	//	________________________________

	public static final String USER_INSERTION_SUCESS = "User Creation success, please check your email to 'Unlock your Account'";

	public static final String USER_INSERTION_FAILED = "User Creation failed, please try again.";

	public static final String USER_UPDATION_SUCESS = "User Updation success, please check your email to 'Unlock your Account'";

	public static final String USER_UPDATION_FAILED = "User updation failed, please try again.";

	public static final String USER_DELETION_SUCESS = "User Accounts updated";

	public static final String USER_DELETION_FAILED = "Could not update user Accounts, please try again.";

	public static final String UNLOCK_SUCCESS_MSG = "Account Unlock Success, You may login now. :)";

	public static final String UNLOCK_FAILED_MSG = "Oops! Could not unlock your account :( \n Please try again using your UNLOCK Link!";

	//	___________________________________

	public static final String USER_MODEL_INSERT_SUCCESS_ATTRIBUTE = "savedMsg";

	public static final String USER_MODEL_INSERT_FAILURE_ATTRIBUTE = "failedMsg";

	public static final String USER_MODEL_UPDATE_SUCCESS_ATTRIBUTE = "updateMsg";

	public static final String USER_MODEL_UPDATE_FAILURE_ATTRIBUTE = "updateFailMsg";

	public static final String USER_MODEL_DELETE_SUCCESS_ATTRIBUTE = "deleteSuccess";

	public static final String USER_MODEL_DELETE_FAILURE_ATTRIBUTE = "deleteFailed";

	public static final String USER_UNLOCK_SUCCESS_ATRRIBUTE = "unlockSuccess";

	public static final String USER_UNLOCK_FAILED_ATRRIBUTE = "unlockFailed";

	//	____________________________________

	public static final String USER_ACCOUNT_STATUS_ACTIVE = "Unlocked";

	public static final String USER_ACCOUNT_STATUS_INACTIVE = "Locked";

	//	___________________________________

	public static final Integer TEMPORARY_PASSWORD_LENGTH = 6;

	//	___________________________________

	public static final String DELETE_SWITCH_YES = "Y";

	public static final String DELETE_SWITCH_NO = "N";

	//	_____________________________________

	public static final String USER_ACCOUNT_LOCKED = "locked";

	public static final String USER_ACCOUNT_UNLOCKED = "unlocked";

	//	_____________________________________

	public static final String EMAIL_DUPLICATE = "duplicate";

	public static final String EMAIL_UNIQUE = "unique";

}
