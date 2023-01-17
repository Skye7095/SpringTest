package com.moonlight.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.mybatis.bo.RealEstateBO;

@Controller
@RequestMapping("mybatis/delete/")
public class DeleteController {
	
	@Autowired
	private RealEstateBO realestateBO;
	
	@ResponseBody
	@RequestMapping("1")
	public String updateRealEstate(@RequestParam("id") int id) {
		
		int count = realestateBO.deleteRealEstate(id);
		return "삭제성공: " + count;
	}
}
