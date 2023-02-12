package com.moonlight.spring.test.weather.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moonlight.spring.test.weather.model.Weather;

@Repository
public interface WeatherDAO {
	public List<Weather> selectReview();
		
	public int addWeather(
			@Param("date") String date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);

}
