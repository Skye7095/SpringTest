package com.moonlight.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.jsp.dao.SellerDAO;
import com.moonlight.spring.test.jsp.model.Seller;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSeller(int id) {
		Seller searchSeller = sellerDAO.selectSeller(id);
		return searchSeller;
	}
	public int addSeller(
			String nickname
			, String profileImage
			, Double temperature) {
		return sellerDAO.addSeller(nickname, profileImage, temperature);
	}
}
