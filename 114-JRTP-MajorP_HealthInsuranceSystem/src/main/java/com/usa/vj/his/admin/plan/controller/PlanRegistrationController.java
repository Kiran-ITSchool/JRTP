package com.usa.vj.his.admin.plan.controller;

import static com.usa.vj.his.app.constants.AdminPlanConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.admin.plan.model.PlanModel;
import com.usa.vj.his.admin.plan.service.PlanService;

@Controller
public class PlanRegistrationController {

	@Autowired
	PlanService planService;

	@GetMapping(value = { "/createPlan" })
	public String launchPlanRegistrationPage(Model model) {
		PlanModel emptyModel = new PlanModel();
		model.addAttribute(PLAN_MODEL_ATTRIBUTE, emptyModel);
		return PLAN_REGISTRATION_LVN;
	}

	/**
	 * 
	 * @param userModel
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = { "/createPlan" })
	public String handleSubmitButton(@ModelAttribute(PLAN_MODEL_ATTRIBUTE) PlanModel planModel,
			RedirectAttributes attributes) {

		//use service and pass contact with data for Insert operation
		boolean planInserted = planService.insertNewPlan(planModel);
		if (planModel.getPlanId() == null || planModel.getPlanId().isEmpty()) {
			if (planInserted)
				attributes.addFlashAttribute(PLAN_MODEL_INSERT_SUCCESS_ATTRIBUTE, PLAN_INSERTION_SUCESS);
			else
				attributes.addFlashAttribute(PLAN_MODEL_INSERT_FAILED_ATTRIBUTE, PLAN_INSERTION_FAILED);
		} else {
			if (planInserted)
				attributes.addFlashAttribute(PLAN_MODEL_UPDATE_SUCCESS_ATTRIBUTE, PLAN_UPDATE_SUCCESS_MSG);
			else
				attributes.addFlashAttribute(PLAN_MODEL_UPDATE_FAILED_ATTRIBUTE, PLAN_UPDATE_FAILED_MSG);
		}
		return "redirect:/createPlan";
	}

}
