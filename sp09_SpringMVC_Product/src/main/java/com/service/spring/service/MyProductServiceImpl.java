package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
@Service
public class MyProductServiceImpl implements MyProductService{

	@Autowired
	private MyProductDAO myProductDAO;
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		// TODO Auto-generated method stub
		return myProductDAO.addProduct(vo);
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return myProductDAO.findProductByName(name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		// TODO Auto-generated method stub
		return myProductDAO.findProductByMaker(maker);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		// TODO Auto-generated method stub
		return myProductDAO.findProducts();
	}

}
