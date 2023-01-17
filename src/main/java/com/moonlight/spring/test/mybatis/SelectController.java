package com.moonlight.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.mybatis.bo.RealEstateBO;
import com.moonlight.spring.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis/select/")
public class SelectController {
	
	@Autowired
	private RealEstateBO realestateBO;
	
	
	// id를 parameter 로 입력 받고 해당하는 id의 매물 정보를 아래와 같이 json으로 출력하세요.
	@ResponseBody
	@RequestMapping("1")
	public RealEstate reviewid(@RequestParam("id") int id) {
		RealEstate review = realestateBO.getReviewId(id);
		return review;
	}
	
	
	// 월세(rentPrice) 를 parameter 로 받고 해당하는 월세보다 낮은 매물을 아래와 같이 json 으로 출력하세요.
	@ResponseBody
	@RequestMapping("2")
	public List<RealEstate> reviewrentprice(@RequestParam("rent") int rent) {
		List<RealEstate> review = realestateBO.getReviewRentPrice(rent);
		return review;
	}
	
	// 아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
	// 넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
	// 가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
	// 등록일을 기준으로 내림 차순으로 정렬하세요.
	@ResponseBody
	@RequestMapping("3")
	public List<RealEstate> reviewareaprice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		// List<RealEstate> review = realestateBO.getReviewAreaPrice(area, price);
		// return review;	
		
		// 결과값을 추가적으로 가공 필요하면 변수를 만들어서 저장하는데, 그대로 리턴하면 간략적으로 기입해도 좋음
		return realestateBO.getReviewAreaPrice(area, price);
	}
	
}
