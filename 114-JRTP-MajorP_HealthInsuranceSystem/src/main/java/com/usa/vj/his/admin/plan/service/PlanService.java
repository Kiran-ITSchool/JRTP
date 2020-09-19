package com.usa.vj.his.admin.plan.service;

import org.springframework.data.domain.Page;

import com.usa.vj.his.admin.plan.entity.PlanEntity;
import com.usa.vj.his.admin.plan.model.PlanModel;

public interface PlanService {

	/**
	 * For inserting new Plan Record
	 * @param planModel
	 * @return
	 */
	public boolean insertNewPlan(PlanModel planModel);
	
	/**
	 * 
	 * @return
	 */
	public Page<PlanEntity> getAllPlans(int pageSize,int pageNo);
	
	/**
	 * 
	 * @param planId
	 * @return
	 */
	public PlanModel getPlanById(String planId);

	/**
	 * 
	 * @param planId
	 * @return
	 */
	public boolean softDeletePlan(String planId);
}
