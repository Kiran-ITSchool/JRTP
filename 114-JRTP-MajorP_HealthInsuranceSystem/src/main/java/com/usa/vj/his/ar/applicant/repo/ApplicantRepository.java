package com.usa.vj.his.ar.applicant.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.vj.his.ar.applicant.entity.ApplicantEntity;

public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Serializable> {

}
