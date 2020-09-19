package com.usa.vj.his.ar.applicant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "APPLCNTS_INFO_TBL")
public class ApplicantEntity {

	@Id
	@GenericGenerator(name = "applicant_seq_generator", strategy = "com.usa.vj.his.generators.ApplicantSeqGenerator")
	@GeneratedValue(generator = "applicant_seq_generator")
	@Column(name = "APPLCTN_NMBR")
	private String applicationNumber;
	
	@Column(name = "APPLCNT_FRST_NM")
	private String applicantFirstName;
	
	@Column(name = "APPLCNT_LST_NM")
	private String applicantLastName;
	
	@Column(name = "APPLCNT_DOB")
	private Date applicantDob;
	
	@Column(name = "APPLCNT_GNDR")
	private String applicantGender;
	
	@Column(name = "APPLCNT_SSN")
	private Long applicantSsn;
	
	@Column(name = "APPLCNT_PHN_NMBR")
	private Long applicantPhoneNumber;
	
	@Column(name = "APPLCNT_EML")
	private String applicantEmail;
	
	
	@Column(name = "CREATED_BY",updatable = false)
	private String createdBy;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON", updatable = false)
	private Date createdDate;
	
	@Column(name = "APPLCNT_STTS")
	private String applicationStatus;
	
	
}
