package com.moonlight.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moonlight.spring.test.lifecycle.model.Introduction;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02RestController {
	
	
	// 1. json 출력 (List, Map)
	// 영화 정보를 저장한 json 을 List와 Map 을 활용해서 아래와 같이 출력하세요.
	@RequestMapping("/1")
	public List<Map<String, Object>> movieListResponse(){
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "봉준호");
		movieInfo.put("time", 131);
		movieInfo.put("title", "기생충");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 0);
		movieInfo.put("director", "르베르토 베니니");
		movieInfo.put("time", 116);
		movieInfo.put("title", "인생은 아름다워");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 12);
		movieInfo.put("director", "크리스토퍼 놀란");
		movieInfo.put("time", 147);
		movieInfo.put("title", "인셉션");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 19);
		movieInfo.put("director", "윤종빈");
		movieInfo.put("time", 133);
		movieInfo.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");
		movieList.add(movieInfo);
		
		movieInfo = new HashMap<>();
		movieInfo.put("rate", 15);
		movieInfo.put("director", "프란시스 로렌스");
		movieInfo.put("time", 137);
		movieInfo.put("title", "헝거게임");
		movieList.add(movieInfo);
		
		return movieList;
	}
	
	// 2. json 출력 (List, Class)
	// 게시판 내용을 저장한 json을 List 와 Class 를 설계하고 활용해서 아래와 같이 출력하세요.
	@RequestMapping("/2")
	public List<Introduction> introductionListResponse(){
	
		List<Introduction> introductionList = new ArrayList<>();
		
		Introduction introduction1 = new Introduction();
		introduction1.setTitle("안녕하세요 가입인사 드립니다.");
		introduction1.setUser("hagulu");
		introduction1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다.");
		introductionList.add(introduction1);
		
		Introduction introduction2 = new Introduction();
		introduction2.setTitle("헐 대박");
		introduction2.setUser("bada");
		introduction2.setContent("오늘 목요일이 었어...금요일인줄");
		introductionList.add(introduction2);
		
		Introduction introduction3 = new Introduction();
		introduction3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		introduction3.setUser("dulumary");
		introduction3.setContent("....");
		introductionList.add(introduction3);
		
		return introductionList;
	}
	
	// 3. ResponseEntity
	// 아래와 같이 게시글 내용을 하나만 json 으로 출력하세요.
	// ResponseEntity 를 이용해서 HttpStatus.INTERNALSERVERERROR 로 상태 코드를 전달하세요.
	@RequestMapping("/3")
	public ResponseEntity<Introduction> entityResponse(){
		Introduction introduction = new Introduction();
		introduction.setTitle("안녕하세요 가입인사 드립니다.");
		introduction.setUser("hagulu");
		introduction.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다.");
		
		ResponseEntity<Introduction> entity = new ResponseEntity(introduction, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
