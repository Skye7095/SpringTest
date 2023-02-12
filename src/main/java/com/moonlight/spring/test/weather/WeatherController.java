package com.moonlight.spring.test.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moonlight.spring.test.weather.bo.WeatherBO;
import com.moonlight.spring.test.weather.model.Weather;

@Controller
@RequestMapping("jstl/weather")
public class WeatherController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/info")
	public String reviewWeatherInfo(Model model) {
		List<Weather> weatherInfos = weatherBO.getReview();
		
		model.addAttribute("weatherInfos", weatherInfos);
		
		return "jstl/weather/weatherinfo";
	}
	
	
	@GetMapping("/insert")
	public String insertWeatherInfo(){
		return "jstl/weather/weatherinput";
	}
	
	
	@PostMapping("/add")
	public String addWeather(
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/jstl/weather/info";
	}
	
}
