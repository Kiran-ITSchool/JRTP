package com.usa.vj.his.app.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.admin.user.service.UserService;
import com.usa.vj.his.app.login.model.ResetPassword;

@Controller
public class ResetPasswordController {

	@Autowired
	private UserService service;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/resetPassword")
	public String resetPasswordLink(Model model) {
		model.addAttribute("PwdModel", new ResetPassword());
		return "ResetPassword";
	}

	/**
	 * Send password to given email account, to reset it.
	 * @param reset
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/resetPassword")
	public String passwordRecovery(@ModelAttribute("PwdModel") ResetPassword reset, RedirectAttributes attributes) {
		boolean userFound = service.getUserByEmail(reset.getRegisteredEmail());
		if (userFound) {
			service.sendPasswordTo(reset.getRegisteredEmail());
			attributes.addFlashAttribute("PwdSent",
					"Password Sent to " + reset.getRegisteredEmail() + ", please reset/update it.");
			return "redirect:/resetPassword";
		} else {
			attributes.addFlashAttribute("PwdNotSent", "Email not found in our Database, try again.");
			return "redirect:/resetPassword";
		}
	}
}
