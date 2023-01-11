package com.moonlight.spring.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.spring.test.database.dao.StoreDao;
import com.moonlight.spring.test.database.model.Store;

@Service
public class StoreBo {
	
	@Autowired
	private StoreDao storeDao;
	
	public List<Store> getStoreList(){
		List<Store> storeList = storeDao.selectStoreList();
		
		return storeList;
	}
}
