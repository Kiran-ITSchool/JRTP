package com.usa.vj.his.admin.plan.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.vj.his.admin.plan.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

}
