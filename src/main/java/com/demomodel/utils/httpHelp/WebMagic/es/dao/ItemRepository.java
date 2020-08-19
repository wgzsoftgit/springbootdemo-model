package com.demomodel.utils.httpHelp.WebMagic.es.dao;


import javax.annotation.Resource;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.demomodel.utils.httpHelp.WebMagic.es.Item;
@Resource
public interface ItemRepository extends ElasticsearchRepository<Item, Integer>{

}
