package com.usa.vj.his.app.login.controller;

import static com.usa.vj.his.app.constants.LoginConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.app.login.model.Login;
import com.usa.vj.his.app.login.service.LoginService;

@Controller
public class LoginUserController {

	@Autowired
	LoginService loginService;

	/**
	 * login page
	 * @param model
	 * @return
	 */
	@GetMapping(value = LOGIN_URL)
	public String userLoginLink(Model model) {
		Login login = new Login();
		model.addAttribute(LOGIN_MODEL_NAME, login);
		return LOGIN_PAGE_LVN;
	}

	/**
	 * validate credentials and give access only if Account is Unlocked
	 * @param login
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = LOGIN_URL)
	public String handleSubmitLogin(@ModelAttribute(LOGIN_MODEL_NAME) Login login, RedirectAttributes attributes) {
		//verify login details using UserService
		UserEntity validUser = loginService.validateLoginCredentials(login);
		if (validUser != null) {
			boolean isUnlocked = loginService.accountUnlockedOrNot(validUser);
			if (isUnlocked) {
				boolean accountIsActive = loginService.accountActiveOrNot(validUser);
				if (accountIsActive) {
					attributes.addFlashAttribute("welcomeName", validUser.getFirstName());
					if (validUser.getUserRole().equalsIgnoreCase(ADMIN_ROLE))
						return "redirect:" + ADMIN_DASHBOARD_URL;
					else
						return "redirect:" + CASE_WORKER_DASHBOARD_URL;
				} else {
					attributes.addFlashAttribute(ACCOUNT_NOT_ACTIVE_ATTRIBUTE, ACCOUNT_NOT_ACTIVE_ERROR_MSG);
					return "redirect:" + LOGIN_URL;
				}
			} else {
				attributes.addFlashAttribute(ACCOUNT_LOCKED_ATTRIBUTE, ACCOUNT_LOCKED_ERROR_MSG);
				return "redirect:" + LOGIN_URL;
			}
		} else {
			attributes.addFlashAttribute(LOGIN_FAILED_ATTRIBUTE, LOGIN_FAILED_ERROR_MSG);
			return "redirect:" + LOGIN_URL;
		}
	}

	/**
	 PRG pattern to dashboard so that user dont have to login 
	 again when refreshing the dashboard page.
	 
	 * @return
	 */
	@RequestMapping(value = CASE_WORKER_DASHBOARD_URL, method = RequestMethod.GET)
	public String redirectTocaseWorkerDashboard() {
		return CASE_WORKER_DASHBOARD_LVN;
	}

	@RequestMapping(value = ADMIN_DASHBOARD_URL, method = RequestMethod.GET)
	public String redirectToAdminDashboard() {
		return ADMIN_DASHBOARD_LVN;
	}
}
