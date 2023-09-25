package com.service.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws IOException {
		//1. sqlMapConfig.xml 읽어들인다
		Reader r = Resources.getResourceAsReader("config/sqlMapConfig.xml");
		//2. SqlSessionFactory 리턴받고
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession 리턴 받고
		SqlSession session = factory.openSession();
		System.out.println("SqlSession이 드디어 만들어 졌습니다..");
		
		//4. selectList() 호출
		List<MySawon> list = session.selectList("SawonMapper.sawonList");
		for(MySawon vo:list) System.out.println(vo);
	}

}
