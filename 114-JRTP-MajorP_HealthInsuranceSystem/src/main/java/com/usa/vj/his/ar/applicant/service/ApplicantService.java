package com.usa.vj.his.ar.applicant.service;

import com.usa.vj.his.ar.applicant.entity.ApplicantEntity;
import com.usa.vj.his.ar.applicant.model.ApplicantModel;

public interface ApplicantService {

	boolean ssnEligibleOrNot(Long ssn);
	
	ApplicantEntity insertApplicantDetails(ApplicantModel model);

	boolean ssnEnrolledOrNot(Long ssn);
	
}
