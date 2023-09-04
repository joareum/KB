package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneDAO;
import com.service.spring.model.PhoneService;
@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	private PhoneDAO phoneDAO;
	
	@Override
	public int insert(Phone phone) {
		return phoneDAO.insert(phone);
	}

	@Override
	public int delete(List<String> list) {
		return phoneDAO.delete(list);
	}

	@Override
	public Phone select(Phone phone) {
		// TODO Auto-generated method stub
		return phoneDAO.select(phone);
	}

	@Override
	public List<Phone> select() {
		// TODO Auto-generated method stub
		return phoneDAO.select();
	}

	@Override
	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return phoneDAO.select(user);
	}

}
