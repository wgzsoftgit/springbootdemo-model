package com.demomodel.utils.httpHelp.WebMagic.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//对应的索引和类型
@Document(indexName = "item",type = "item ")
public class Item {

	@Id  //主键
	//是否索引    是否存储   数据类型
	@Field(index = true , store = true, type = FieldType.Integer)
	private Integer id;
	@Field( index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart",type = FieldType.Text)
	private String title;
	@Field( index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart",type = FieldType.Text)
	private String content;
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
