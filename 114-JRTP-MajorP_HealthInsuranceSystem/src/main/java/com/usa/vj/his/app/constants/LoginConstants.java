package com.usa.vj.his.app.constants;

public interface LoginConstants {

	public static final String ADMIN_ROLE = "Admin";

	public static final String ACCOUNT_NOT_ACTIVE_ATTRIBUTE = "AccountNotActive";

	public static final String ACCOUNT_NOT_ACTIVE_ERROR_MSG = "Account is de-activated, please contact admin.";

	public static final String ACCOUNT_LOCKED_ATTRIBUTE = "accountLocked";

	public static final String ACCOUNT_LOCKED_ERROR_MSG = "You account is Locked, please unlock account using email we sent.<br> You may contact administrator as well.";

	public static final String LOGIN_URL = "/userLogin";

	public static final String LOGIN_MODEL_NAME = "loginModel";

	public static final String LOGIN_PAGE_LVN = "LoginPage";

	public static final String LOGIN_FAILED_ATTRIBUTE = "loginFailed";

	public static final String LOGIN_FAILED_ERROR_MSG = "Invalid Email or Password, please try again with valid credentials.";

	public static final String CASE_WORKER_DASHBOARD_URL = "/cworkerdashboard";

	public static final String CASE_WORKER_DASHBOARD_LVN = "CaseWorkerDashboard";

	public static final String ADMIN_DASHBOARD_URL = "/admindashboard";

	public static final String ADMIN_DASHBOARD_LVN = "AdminDashboard";

}
