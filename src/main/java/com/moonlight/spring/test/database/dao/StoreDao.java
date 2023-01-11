package com.moonlight.spring.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moonlight.spring.test.database.model.Store;

@Repository
public interface StoreDao {
	public List<Store> selectStoreList();
}
