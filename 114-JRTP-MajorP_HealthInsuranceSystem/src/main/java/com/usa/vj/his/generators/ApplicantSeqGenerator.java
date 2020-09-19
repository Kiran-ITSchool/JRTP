package com.usa.vj.his.generators;

import java.io.Serializable;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ApplicantSeqGenerator implements IdentifierGenerator {

	private static final String APPLICANT_SEQ_QUERY = "SELECT applicant_seq.nextval FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "HISARN";
		String suffix = "";
		String applicantSeq = "";
		try {
			ResultSet rs = session.connection().createStatement().executeQuery(APPLICANT_SEQ_QUERY);
			if (rs.next()) {
				suffix = String.valueOf(rs.getInt(1));
				applicantSeq = prefix + suffix;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return applicantSeq;
	}

}
