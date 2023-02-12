package com.moonlight.spring.test.weather.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.moonlight.spring.test.weather.dao.WeatherDAO;
import com.moonlight.spring.test.weather.model.Weather;

@Service
public class WeatherBO {
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weather> getReview(){
		List<Weather> review = weatherDAO.selectReview();
		return review;
	}
	
	
	public int addWeather(
			String date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		return weatherDAO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
