package com.moonlight.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.mybatis.bo.RealEstateBO;

@Controller
@RequestMapping("/mybatis/update/")
public class UpdateController {
	
	@Autowired
	private RealEstateBO realestateBO;
	
	@ResponseBody
	@RequestMapping("1")
	public String updateRealEstate() {
		
		// id가 24 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
		int count = realestateBO.updateRealEstate(21, "전세", 70000);
		return "수정사항: " + count;
	}
}
