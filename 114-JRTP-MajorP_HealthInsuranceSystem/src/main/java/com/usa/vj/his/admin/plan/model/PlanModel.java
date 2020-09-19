package com.usa.vj.his.admin.plan.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanModel {

	private String planId;
	private String planName;
	private String planDesc;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	private String activatedSwitch;

}
