package com.demomodel.controller.baseController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.bean.User;
import com.google.gson.Gson;

@RestController
public class textcontroller extends BaseController{

	
	@RequestMapping
	public ResponseEntity<String> Responsetext() {
		Gson gson=new Gson();
		String src="[1]";
		String responsestr=gson.toJson(src);
		//headers  子类可以用父类的所有属性
		return new ResponseEntity<String>(responsestr,headers,HttpStatus.OK);
		
	}
	
	@RequestMapping(value={"/department/all"})
	public ResponseEntity<List<User>> getAllDepartments(Model model) {
		
		List<User> departments = null;//
		
		return new ResponseEntity<List<User>>(departments, HttpStatus.OK);
	}
	
	@RequestMapping(value={"/user/login"}, method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam(value="phone", required=true) String phone,@RequestParam(value="password", required=true) String password) {
		ResponseStatus rs = new ResponseStatus();
		User user = null;
		if(user == null) {
			rs.setStatus(ResponseStatus.ERROR);
			rs.setErrorMessage("用户名或密码错误");
			return new ResponseEntity<ResponseStatus>(rs, HttpStatus.OK);
		} else {
			rs.setStatus(ResponseStatus.OK);
			rs.setResult(user);
			return new ResponseEntity<ResponseStatus>(rs, HttpStatus.OK);
		}
	}
	
}
