package com.moonlight.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moonlight.spring.test.ajax.bo.FavoriteBO;
import com.moonlight.spring.test.ajax.model.Favorite;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/list")
	public String FavoriteList(Model model) {
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "/ajax/favorite/list";
	}
	
	
	// 즐겨찾기 추가 api
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url){
		
		int count = favoriteBO.addFavorite(name, url);
		
		// response
		// 성공시: {"result":"success"}
		// 실패시: {"result":"fail"}
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/input")
	public String input() {
		return "/ajax/favorite/input";
	}
	
	@PostMapping("/is_duplicateURL")
	@ResponseBody
	public Map<String, Boolean> is_duplicateURL(@RequestParam("url") String url) {
		Map<String, Boolean> result = new HashMap<>();
		
//		if(favoriteBO.is_duplicateURL(url)) {
//			result.put("is_duplicate", true);
//		}else {
//			result.put("is_duplicate", false);
//		}
		
		result.put("is_duplicate", favoriteBO.is_duplicateURL(url));
		
		return result;
	}
	
	// 삭제 api
	// id를 전달 받고, 해당 행을 삭제하는 api
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		int count = favoriteBO.deleteFavotite(id);
		
		// 삭제 성공시 {"result":"success"}
		// 삭제 성공시 {"result":"fail"}
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
}
