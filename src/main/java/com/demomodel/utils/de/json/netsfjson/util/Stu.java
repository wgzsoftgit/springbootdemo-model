package com.demomodel.utils.de.json.netsfjson.util;

public class Stu {
	 private String name;
	private String password;
	public Stu() {
		this.name="sa";
		this.password="123";
	}

	public Stu(String string, String string2) {
		this.name=string;
		this.password=string2;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Stu [name=" + name + ", password=" + password + "]";
	}
	

}
