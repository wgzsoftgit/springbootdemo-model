package com.demomodel.utils.httpHelp.WebMagic.es.service;

import java.util.List;

import com.demomodel.utils.httpHelp.WebMagic.es.Item;

public interface ItemService {

	public void save(Item item);  //保存
	public void saveAll(List<Item> item);//批量保存
	public void delete(Item item);//删除
	public Iterable<Item> selectFindAll(); //查询所有数据
	
}
