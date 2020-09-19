package com.usa.vj.his.ar.applicant.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ApplicantModel {

	private String applicationNumber;
	private String applicantFirstName;
	private String applicantLastName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date applicantDob;
	private String applicantGender;
	private Long applicantSsn;
	private Long applicantPhoneNumber;
	private String applicantEmail;

}
