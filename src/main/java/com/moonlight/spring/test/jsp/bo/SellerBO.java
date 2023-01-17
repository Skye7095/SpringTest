package com.moonlight.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.jsp.dao.SellerDAO;
import com.moonlight.spring.test.jsp.model.Seller;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public Seller getSeller(Integer id) {
		if(id == null) {
			return sellerDAO.selectLastSeller();
		}else {
			return sellerDAO.selectSeller(id);
		}
	}
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSellerById(int id) {
		return sellerDAO.selectSeller(id);
	}
	public int addSeller(
			String nickname
			, String profileImage
			, double temperature) {
		return sellerDAO.addSeller(nickname, profileImage, temperature);
	}
}
