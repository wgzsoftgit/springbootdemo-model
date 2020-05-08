package com.demomodel.utils.de.gson.util.maptojson.bean;
public class MyEntry {
    private String name;
    private int age;
    public String address;
    public int salary;
    // getter、setter、toString
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public int getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
    
}