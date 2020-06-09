package com.demomodel.controller.qualifierText;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.bean.User;

@Service("menuService1")
public class MenuServiceImpl1 implements IMenuService {

	/**
	 * 获取所有菜单
	 */
	@Override
	public String getAllMenuList() {
		
			return "menuService1被调用";
	}
}
//https://blog.csdn.net/LI_AINY/java/article/details/98602322