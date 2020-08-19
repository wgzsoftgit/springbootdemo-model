package com.demomodel.utils.httpHelp.WebMagic.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.utils.httpHelp.WebMagic.es.Item;
import com.demomodel.utils.httpHelp.WebMagic.es.dao.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private ItemRepository itemService;
	@Override
	public void save(Item item) {
		this.itemService.save(item);
		
		
	}
	
	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		this.itemService.delete(item);
	}

	@Override
	public void saveAll(List<Item> item) {
		this.itemService.saveAll(item);
		
	}

	@Override
	public Iterable<Item> selectFindAll() {
		Iterable<Item> Items = this.itemService.findAll();
		return Items;
	}
	

}
