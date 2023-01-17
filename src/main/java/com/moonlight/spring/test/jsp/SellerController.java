package com.moonlight.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.jsp.bo.SellerBO;
import com.moonlight.spring.test.jsp.model.Seller;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/seller_info")
	public String lastSeller(@RequestParam(value="id", required=false) Integer id, Model model) {
//		if(id == null) {
//			Seller lastSeller = sellerBO.getLastSeller();
//			model.addAttribute("seller", lastSeller);
//		}else {
//			Seller searchSeller = sellerBO.getSeller(id);
//			model.addAttribute("seller", searchSeller);
//		}
		
		Seller seller = sellerBO.getSeller(id);
		model.addAttribute("seller", seller);
		
		return "jsp/sellerinfo";
	}
	
	
	@ResponseBody
	@PostMapping("/add")
	public String addUser(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerBO.addSeller(nickname, profileImage, temperature);
		return "삽입결과: " + count;
	}
	
	@GetMapping("/input")
	public String addSeller() {
		return "jsp/addseller";
	}
}
