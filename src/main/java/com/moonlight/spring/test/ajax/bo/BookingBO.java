package com.moonlight.spring.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.ajax.dao.BookingDAO;
import com.moonlight.spring.test.ajax.model.Booking;

@Service
public class BookingBO {
	
	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> getBookingList(){
		
		return bookingDAO.selectBookingList();
	}
	
	public int addBooking(
			String name
			, String date
			, int day
			, int headcount
			, String phoneNumber) {
		return bookingDAO.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
	}
	
	public int deleteBooking(int id) {
		return bookingDAO.deleteBooking(id);
	}
	
	// 딱 하나의 결과를 조회될 것으로 예상해서 return type은 Booking로 돌려받음
	public Booking getConfirmBooking(
			String name
			, String phoneNumber){
		return bookingDAO.confirmBookingList(name, phoneNumber);
	}
}
