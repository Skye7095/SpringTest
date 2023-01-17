package com.moonlight.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.mybatis.bo.RealEstateBO;
import com.moonlight.spring.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis/insert/")
public class InsertController {
	
	@Autowired
	private RealEstateBO realestateBO;
	
		// 1. 객체로 insert 하기
		@ResponseBody
		@RequestMapping("1")
		public String addRealEstate1() {
			RealEstate realestate = new RealEstate();
			realestate.setRealtorId(3);
			realestate.setAddress("푸르지용 리버 303동 1104호");
			realestate.setArea(89);
			realestate.setType("매매");
			realestate.setPrice(100000);
			// mapper에서 id를 변수 만들었지만 여기서 id변수 입력하지 않았다. 그래도 잘 실행됐다.
			// 객체 생성하는 순간부터 해당 객체안에 id자리가 생겼다. 입력하지 않는 변수들이 다 0 으로 잡힘.(rentprice도 마찬가지로 null대신 0으로 됨)
			// 이 상태에서 mysql이 id가 0일 가능성이 없고 알아서 자동적으로 숫자를 채워줬다.
			// 크게 문제는 없지만 그래도 정확성을 위해 mapper에서 사용하지 않는 변수를 아예 만들지 않는 것이 추천한다.
			
			int count = realestateBO.addRealEstateByObject(realestate);
			return "실행결과: " + count;
		}
		
		// 2. field 로 insert 하기
		@ResponseBody
		@RequestMapping("2")
		public String addRealEstate2(@RequestParam("realtorId") int realtorid) {
			int count = realestateBO.addRealEstate(3, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
			return "입력 성공: " + count;
		}
}
