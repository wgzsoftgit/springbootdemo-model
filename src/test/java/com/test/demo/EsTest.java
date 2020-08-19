package com.test.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demomodel.WebApplication;
import com.demomodel.utils.httpHelp.WebMagic.es.Item;
import com.demomodel.utils.httpHelp.WebMagic.es.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( locations = "classpath:application1.xml") //配置文件 spring使用的方式
@SpringBootTest(classes = WebApplication.class)
public class EsTest {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	//创建索引和映射
	@Test
	public void createIndex() {
		this.elasticsearchTemplate.createIndex(Item.class);
		this.elasticsearchTemplate.putMapping(Item.class);
	}
	@org.junit.Test
	public void testsave() {
		Item item=new Item();
		item.setId(1);
		item.setContent("se");
		item.setTitle("asdasd");
		itemService.save(item);
		
	}
	@org.junit.Test
	public void testsaveAll() {
		List<Item> list=new ArrayList<Item>();
		for (int i = 0; i <10; i++) {
			Item item=new Item();
			item.setId(i);
			item.setContent("se");
			item.setTitle("asdasd");
			list.add(item);
		}
		itemService.saveAll(list);//批量保存
		
	}
	@org.junit.Test
	public void testdel() {
		Item item=new Item();
		item.setId(1);
		item.setContent("se");
		item.setTitle("asdasd");
		itemService.delete(item);
		
	}
	
	@org.junit.Test
	public void testFindAll() {
		Iterable<Item> findAll = itemService.selectFindAll();
		for (Item item : findAll) {
			System.err.println(item);
		}
	}
}
