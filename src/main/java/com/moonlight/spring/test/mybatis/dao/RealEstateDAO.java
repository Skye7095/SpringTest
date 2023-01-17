package com.moonlight.spring.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.moonlight.spring.test.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	
	public RealEstate selectReviewId(@Param("id") int id);
	
	public List<RealEstate> selectReviewRentPrice(@Param("rent") int rent);
	
	public List<RealEstate> selectReviewAreaPrice(
			@Param("area") int rent
			, @Param("price") int price);
	
	public int addReviewByObject(RealEstate realestate);
	
	public int addRealEstate(
			@Param("realtorId") int realtorid
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rent
			);
	
	public int updateRealEstate(@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price
			);
	
	public int deleteRealEstate(@Param("id") int id);
}
