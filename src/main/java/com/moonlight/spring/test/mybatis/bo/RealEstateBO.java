package com.moonlight.spring.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.moonlight.spring.test.mybatis.dao.RealEstateDAO;
import com.moonlight.spring.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO reviewDAO;
	
	public RealEstate getReviewId(int id) {
		RealEstate review = reviewDAO.selectReviewId(id);
		return review;
	}
	
	
	public List<RealEstate> getReviewRentPrice(int rent) {
		List<RealEstate> review = reviewDAO.selectReviewRentPrice(rent);
		return review;
	}
	
	public List<RealEstate> getReviewAreaPrice(int area, int price){
		// List<RealEstate> review = reviewDAO.selectReviewAreaPrice(area, price);
		// return review;
		
		// 결과값을 추가적으로 가공 필요하면 변수를 만들어서 저장하는데, 그대로 리턴하면 간략적으로 기입해도 좋음
		return reviewDAO.selectReviewAreaPrice(area, price);
	}
	
	// 객체로 insert 하기
	public int addRealEstateByObject(RealEstate realestate) {
		return reviewDAO.addReviewByObject(realestate);
	}
	
	// field 로 insert 하기
	public int addRealEstate(int realtorid, String address, int area, String type, int price, int rent) {
		return reviewDAO.addRealEstate(realtorid, address, area, type, price, rent);
	}
	
	// 변경할 대상 id, 변경할 type, 변경할 price
	public int updateRealEstate(int id, String type, int price) {
		return reviewDAO.updateRealEstate(id, type, price);
	}
	
	public int deleteRealEstate(int id) {
		return reviewDAO.deleteRealEstate(id);
	}
}
