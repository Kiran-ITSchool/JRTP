package com.usa.vj.his.admin.plan.service;

import static com.usa.vj.his.app.constants.AdminPlanConstants.ACTIVE_PLAN_SW_NO;
import static com.usa.vj.his.app.constants.AdminUserConstants.DELETE_SWITCH_NO;
import static com.usa.vj.his.app.constants.AdminUserConstants.DELETE_SWITCH_YES;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.usa.vj.his.admin.plan.entity.PlanEntity;
import com.usa.vj.his.admin.plan.model.PlanModel;
import com.usa.vj.his.admin.plan.repo.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepo;

	@Override
	public boolean insertNewPlan(PlanModel planModel) {

		PlanEntity planEntity = new PlanEntity();
		BeanUtils.copyProperties(planModel, planEntity);
		planEntity.setActivatedSwitch(ACTIVE_PLAN_SW_NO);
		PlanEntity savedEntity = planRepo.save(planEntity);
		if (savedEntity.getPlanId() != null)
			return true;
		else
			return false;
	}

	public Page<PlanEntity> getAllPlans(int pageSize, int pageNo) {

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<PlanEntity> planEntities = planRepo.findAll(pageRequest);
		return planEntities;
	}

	@Override
	public PlanModel getPlanById(String planId) {

		Optional<PlanEntity> planById = planRepo.findById(planId);

		if (planById.isPresent()) {
			PlanModel model = new PlanModel();
			PlanEntity entity = planById.get();
			BeanUtils.copyProperties(entity, model);
			return model;
		}
		return null;
	}

	@Override
	public boolean softDeletePlan(String planId) {
		Optional<PlanEntity> planEntity = planRepo.findById(planId);
		if (planEntity.isPresent()) {
			PlanEntity entityToSoftDelete = planEntity.get();
			if (entityToSoftDelete.getActivatedSwitch().contentEquals(DELETE_SWITCH_NO))
				entityToSoftDelete.setActivatedSwitch(DELETE_SWITCH_YES);
			else
				entityToSoftDelete.setActivatedSwitch(DELETE_SWITCH_NO);
			planRepo.save(entityToSoftDelete);
			return true;
		}
		return false;
	}

}
