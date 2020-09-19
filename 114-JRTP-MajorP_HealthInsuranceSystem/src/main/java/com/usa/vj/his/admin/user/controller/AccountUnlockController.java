package com.usa.vj.his.admin.user.controller;

import static com.usa.vj.his.app.constants.AdminUserConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usa.vj.his.admin.user.model.UnlockUser;
import com.usa.vj.his.admin.user.service.UserService;

@Controller
public class AccountUnlockController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/unlockUserAcc")
	public String unlockAccountLink(@RequestParam("email") String email, Model model) {
		UnlockUser user = new UnlockUser();
		model.addAttribute("email", email);
		model.addAttribute("unlockModel", user);
		return UNLOCK_USER_LVN;
	}

	@PostMapping(value = "unlockWithNewPwd")
	public String newPwdUnlock(@ModelAttribute(UNLOCK_MODEL_NAME) UnlockUser unlock, Model model) {
		//user Service
		boolean isValid = userService.validateTempPwd(unlock);
		if (isValid)
			model.addAttribute(USER_UNLOCK_SUCCESS_ATRRIBUTE, UNLOCK_SUCCESS_MSG);
		else
			model.addAttribute(USER_UNLOCK_FAILED_ATRRIBUTE, UNLOCK_FAILED_MSG);

		return "unlockSuccess";
	}
}
