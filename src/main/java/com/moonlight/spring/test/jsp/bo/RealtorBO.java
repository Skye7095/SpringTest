package com.moonlight.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.jsp.dao.RealtorDAO;
import com.moonlight.spring.test.jsp.model.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorDAO realtorDAO;
	
	public int insertRealtorByObject(Realtor realtor) {
		return realtorDAO.insertRealtorByObject(realtor);
	}
}
