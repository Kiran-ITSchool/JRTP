package com.usa.vj.his.admin.user.controller;

import static com.usa.vj.his.app.constants.AdminUserConstants.DISPLAY_ALL_USERS_LVN;
import static com.usa.vj.his.app.constants.AdminUserConstants.USER_DELETION_FAILED;
import static com.usa.vj.his.app.constants.AdminUserConstants.USER_DELETION_SUCESS;
import static com.usa.vj.his.app.constants.AdminUserConstants.USER_EDIT_LVN;
import static com.usa.vj.his.app.constants.AdminUserConstants.USER_MODEL_DELETE_FAILURE_ATTRIBUTE;
import static com.usa.vj.his.app.constants.AdminUserConstants.USER_MODEL_DELETE_SUCCESS_ATTRIBUTE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.admin.user.entity.UserEntity;
import com.usa.vj.his.admin.user.model.UserModel;
import com.usa.vj.his.admin.user.service.UserService;

@Controller
public class ViewAllUsersController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/editUser" })
	public String editContactLink(@RequestParam("userId") Integer userId, Model model) {
		UserModel userModel = userService.getUserById(userId);
		model.addAttribute("UserModel", userModel);
		return USER_EDIT_LVN;
	}

	/**
	 * 
	 * @param cid
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/deleteUser" })
	public String deleteContact(@RequestParam("userId") Integer userId, RedirectAttributes attributes) {
		UserEntity entity = userService.softDeleteUser(userId);
		String role=entity.getUserRole();
		if (entity.getUserId()==userId) {
			attributes.addFlashAttribute(USER_MODEL_DELETE_SUCCESS_ATTRIBUTE, USER_DELETION_SUCESS);
		} else {
			attributes.addFlashAttribute(USER_MODEL_DELETE_FAILURE_ATTRIBUTE, USER_DELETION_FAILED);
		}
		return "redirect:/displayAllUsers?role="+role;
	}

	/**
	* Display all records
	* @param model
	* @return
	*/
	@GetMapping(value = { "/displayAllUsers" })
	public String handleViewAllUsersListLink(HttpServletRequest req,Model model) {
		
		String role="CaseWorker";
		
		if(req.getParameter("role").equalsIgnoreCase("Admin")) {
			role="Admin";
		}
		
		List<UserModel> allUsers = userService.getAllUsers(role);
		model.addAttribute("users", allUsers);
		return DISPLAY_ALL_USERS_LVN;
	}
}
