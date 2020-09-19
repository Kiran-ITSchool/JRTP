package com.usa.vj.his.ar.applicant.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.usa.vj.his.ar.applicant.entity.ApplicantEntity;
import com.usa.vj.his.ar.applicant.model.ApplicantModel;
import com.usa.vj.his.ar.applicant.repo.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepository applicantRepo;

	private static final String END_POINT_URL_SSN_STT_VALIDATE = "http://localhost:2525/ssa/validSsnStt/{ssn}/{state}";
	private static final String END_POINT_URL_SSN_FOUND = "http://localhost:2525/ssa/validSsn/{ssn}";

	@Override
	public boolean ssnEligibleOrNot(Long ssn) {
		WebClient webClient = WebClient.create();
		String response = webClient.get().uri(END_POINT_URL_SSN_STT_VALIDATE, ssn, "DE").retrieve().bodyToMono(String.class).block();
		if (response.equalsIgnoreCase("valid"))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean ssnEnrolledOrNot(Long ssn) {
		WebClient webClient = WebClient.create();
		String response = webClient.get().uri(END_POINT_URL_SSN_FOUND, ssn).retrieve().bodyToMono(String.class).block();
		if (response.equalsIgnoreCase("found"))
			return true;
		else
			return false;
	}

	@Override
	public ApplicantEntity insertApplicantDetails(ApplicantModel model) {
		ApplicantEntity applicantEntity = new ApplicantEntity();
		BeanUtils.copyProperties(model, applicantEntity);
		applicantEntity.setApplicationStatus("In-progress");
		ApplicantEntity savedApplicant = applicantRepo.save(applicantEntity);
		if (savedApplicant.getApplicationNumber() != null)
			return savedApplicant;
		else
			return null;
	}

}
