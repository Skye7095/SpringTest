package com.moonlight.spring.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.ajax.dao.FavoriteDAO;
import com.moonlight.spring.test.ajax.model.Favorite;

@Service
public class FavoriteBO {
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public List<Favorite> getFavoriteList(){
		return favoriteDAO.selectFavoriteList();
	}
	
	public int addFavorite(
			String name
			, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	public boolean is_duplicateURL(String url) {
		int count = favoriteDAO.selectCountURL(url);
		
		if(count == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public int deleteFavotite(int id) {
		return favoriteDAO.deleteFavorite(id);
	}
}
