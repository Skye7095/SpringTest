package com.moonlight.spring.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moonlight.spring.test.jsp.model.Seller;


@Repository
public interface SellerDAO {
	
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
	
	public int addSeller(
			@Param("nickname") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature);
}
