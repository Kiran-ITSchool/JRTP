package com.usa.vj.his.generators;

import java.io.Serializable;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PlanSeqGenerator implements IdentifierGenerator {

	private static final String PLAN_SEQ_QUERY = "SELECT plan_seq.nextval FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "HIS-PLN-";
		String suffix = "";
		String planSeq = "";
		try {
			ResultSet rs = session.connection().createStatement().executeQuery(PLAN_SEQ_QUERY);
			if (rs.next()) {
				suffix = String.valueOf(rs.getInt(1));
				planSeq = prefix + suffix;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return planSeq;
	}

}
