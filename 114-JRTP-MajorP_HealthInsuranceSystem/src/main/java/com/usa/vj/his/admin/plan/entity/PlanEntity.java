package com.usa.vj.his.admin.plan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "HIS_PLNS_DTA_TBL")
public class PlanEntity {

	@Id
	@Column(name = "PLN_ID")
	@GenericGenerator(name = "plan_seq_generator", strategy = "com.usa.vj.his.generators.PlanSeqGenerator")
	@GeneratedValue(generator = "plan_seq_generator")
	private String planId;

	@Column(name = "PLN_NM")
	private String planName;

	@Column(name = "PLN_DESC")
	private String planDesc;

	@Temporal(TemporalType.DATE)
	@Column(name = "STRT_DT")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DT")
	private Date endDate;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DT",updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", insertable = false)
	private Date updatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "ACTIVATED_SW")
	private String activatedSwitch;

}
