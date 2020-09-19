package com.usa.vj.his.admin.plan.controller;

import static com.usa.vj.his.app.constants.AdminPlanConstants.DISPLAY_ALL_PLANS_LVN;
import static com.usa.vj.his.app.constants.AdminPlanConstants.PLAN_DELETION_FAILED;
import static com.usa.vj.his.app.constants.AdminPlanConstants.PLAN_DELETION_SUCESS;
import static com.usa.vj.his.app.constants.AdminPlanConstants.PLAN_EDIT_LVN;
import static com.usa.vj.his.app.constants.AdminPlanConstants.PLAN_MODEL_DELETE_FAILED_ATTRIBUTE;
import static com.usa.vj.his.app.constants.AdminPlanConstants.PLAN_MODEL_DELETE_SUCCESS_ATTRIBUTE;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.admin.plan.entity.PlanEntity;
import com.usa.vj.his.admin.plan.model.PlanModel;
import com.usa.vj.his.admin.plan.service.PlanService;

@Controller
public class ViewAllPlansController {

	@Autowired
	private PlanService planService;

		/**
			* 
			* @param userId
			* @param model
			* @return
			*/
	
	@GetMapping(value = { "/editPlan" })
	public String editPlanLink(@RequestParam("planId") String planId, Model model) {
	PlanModel planModel = planService.getPlanById(planId);
	System.out.println(planModel.getStartDate());
	System.out.println(planModel.getEndDate());
	model.addAttribute("PlanModel", planModel);
	return PLAN_EDIT_LVN;
	}
	
	/**
		* 
		* @param cid
		* @param model
		* @return
		*/
			@GetMapping(value = { "/deletePlan" })
			public String deletePlan(@RequestParam("planId") String planId, RedirectAttributes attributes) {
			boolean deletedPlan = planService.softDeletePlan(planId);
			if (deletedPlan) {
				attributes.addFlashAttribute(PLAN_MODEL_DELETE_SUCCESS_ATTRIBUTE, PLAN_DELETION_SUCESS);
			} else {
				attributes.addFlashAttribute(PLAN_MODEL_DELETE_FAILED_ATTRIBUTE, PLAN_DELETION_FAILED);
			}
			return "redirect:/displayAllPlans";
			}
			

	/**
	* Display all records
	* @param model
	* @return
	*/
	@GetMapping(value = { "/displayAllPlans" })
	public String handleViewAllPlansListLink(HttpServletRequest req,Model model) {
		
		Integer currPno = 1;
		Integer pageSize = 2;

		String pno = req.getParameter("pno");
		if (pno != null && !pno.equals("")) {
			currPno = Integer.parseInt(pno);
		}
		
		Page<PlanEntity> pageData = planService.getAllPlans(pageSize, currPno - 1);
		List<PlanEntity> entities = pageData.getContent();
		int totalPages = pageData.getTotalPages();

		List<PlanModel> planList = entities.stream().map(entity -> {
			PlanModel planModel= new PlanModel();
			BeanUtils.copyProperties(entity, planModel);
			return planModel;
		}).collect(Collectors.toList());
		
		model.addAttribute("plans", planList);
		model.addAttribute("tp", totalPages);
		model.addAttribute("cpn", currPno);
		return DISPLAY_ALL_PLANS_LVN;
	}

}
