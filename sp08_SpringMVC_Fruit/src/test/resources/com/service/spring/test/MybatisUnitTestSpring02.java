package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

public class MybatisUnitTestSpring02 {

	@Test
	public void DITest() throws Exception{
		//빈을 생성하는 DI컨테이너를 생성..Pre Loading.. 클라이언트의 요청시 getBean 타임이 아닌 주문서를 읽자마자 빈을 생성
		ApplicationContext factory = new ClassPathXmlApplicationContext("bean/itemservice.xml");
		
		factory.getBean("itemCatalogImpl");
		ItemCatalog service = (ItemCatalog)factory.getBean("itemCatalogImpl");
		System.out.println("====getListItem========");
		List<Item> list = service.getItemList();
		for(Item i : list) System.out.println(i);
		
		System.out.println("====getItem========");
		Item item = service.getItem(2222);
		System.out.println(item);
	}
}
