package com.demomodel.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "name")
    private String name;
    
    
    private int i;
    private int j;
    public User() {}
	public User(int i, int j) {
		this.i=i;
		this.j=j;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void setJ(int j) {
		this.j = j;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", i=" + i + ", j=" + j + "]";
	}
	
    
}