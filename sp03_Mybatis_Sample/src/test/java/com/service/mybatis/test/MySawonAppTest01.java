package com.service.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception {
		//1.  폼으로부터 가입하려는 사원의 정보를 받는다...
		MySawon pvo = new MySawon();
		pvo.setId("hahash");
		pvo.setPwd("9006");
		pvo.setName("김연아");
		pvo.setAge(35);
		
		//2. SqlMapConfig.xml 파일을 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/sqlMapConfig.xml");
		
		//3. SqlsessionFactory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession이 드디어 만들어 졌습니다..");
		
		/*
		 * SqlSession 쿼리문을 수행하는 모든 기능을 다 가지고 있음!!
		 * int insert()
		 * int delete()
		 * int update()
		 * 
		 * List selectList()
		 * Object selectOne()
		 */
		
		//sawonAdd 쿼리문을 단위테스트..insert() 실행
		session.insert("SawonMapper.sawonAdd", pvo); //DB입력
		System.out.println(pvo.getName()+"님이 회원등록 성공^^");
		
		//반드시~~!!
		session.commit();
		session.close();
	}

}
