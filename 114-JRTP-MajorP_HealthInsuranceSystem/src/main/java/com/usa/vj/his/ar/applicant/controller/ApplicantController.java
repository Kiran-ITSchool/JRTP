package com.usa.vj.his.ar.applicant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.vj.his.ar.applicant.entity.ApplicantEntity;
import com.usa.vj.his.ar.applicant.model.ApplicantModel;
import com.usa.vj.his.ar.applicant.service.ApplicantService;

@Controller
public class ApplicantController {

	@Autowired
	ApplicantService applicantService;

	/**
	 * GET req to load Applicant Registration Page
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/applicantRegister")
	public String launchApplicantPage(Model model) {
		ApplicantModel applicantModel = new ApplicantModel();
		model.addAttribute("ApplicantModel", applicantModel);
		return "ApplicantRegistration";
	}

	/**
	 * To register applicant based on 2 conditions,
	 * 1. SSN is valid/enrolled with SSA-WEB Rest Resource.
	 * 2. SSN and STATE are eligible to apply or not.
	 * 
	 * if both are satisfied, generate an Application Number and insert data into table.
	 * 
	 * @param applicanModel
	 * @param attributes
	 * @return
	 */
	@PostMapping(value = "/applicantRegister")
	public String handleApplicantRegisterButton(@ModelAttribute("ApplicantModel") ApplicantModel applicantModel,
			RedirectAttributes attributes) {

		boolean ssnEnrolled = applicantService.ssnEnrolledOrNot(applicantModel.getApplicantSsn());
		if (ssnEnrolled) {
			boolean ssnEligible = applicantService.ssnEligibleOrNot(applicantModel.getApplicantSsn());
			if (ssnEligible) {
				ApplicantEntity registeredApplicant = applicantService.insertApplicantDetails(applicantModel);
				if (registeredApplicant != null) {
					attributes.addFlashAttribute("RegistrationSuccess",
							"Registration Successful, <br> HIS-ARN-Reference number : "
									+ registeredApplicant.getApplicationNumber());
					return "redirect:/applicantRegister";
				} else {
					attributes.addFlashAttribute("RegistrationFailed", "Registration Failed");
					return "redirect:/applicantRegister";
				}

			} else {
				attributes.addFlashAttribute("NotEligibleSsn",
						"Registration Failed. <br> Reason : You do not belong to Delaware State, not eligible. ");
				return "redirect:/applicantRegister";
			}

		} else {
			attributes.addFlashAttribute("InvalidSsn", "Registration Failed. <br> Reason : Invalid SSN. ");
			return "redirect:/applicantRegister";
		}
	}

}
