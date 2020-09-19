package com.usa.vj.his.app.login.service;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.app.login.model.Login;

public interface LoginService {

	UserEntity validateLoginCredentials(Login login);

	boolean accountUnlockedOrNot(UserEntity entity);

	boolean accountActiveOrNot(UserEntity entity);
}
