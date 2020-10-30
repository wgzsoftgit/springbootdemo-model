package com.demomodel.controller.getSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demomodel.bean.User;
import com.gargoylesoftware.css.parser.javacc.ParseException;

import net.sf.json.JSONObject;

public class SessionController {

	/**
	 * 获取的数据存入session
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws ParseException
	 */
	//把数据存进 zbruku
	public void Chasession(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException{
		int purchaseid = Integer.parseInt(request.getParameter("purchaseid"));
		BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));
		String invoice = request.getParameter("invoice");
		String dealsite = request.getParameter("dealsite");
		String drugname = request.getParameter("drugname");
		String unit = request.getParameter("unit");
		BigDecimal costprice = new BigDecimal(request.getParameter("costprice"));
		BigDecimal retailprice = new BigDecimal(request.getParameter("retailprice"));
		String countryzi = request.getParameter("countryzi");
		String batchnumber = request.getParameter("batchnumber");
		String number = request.getParameter("number");
		BigDecimal lingshou = quantity.multiply(retailprice);
		BigDecimal chengbei = quantity.multiply(costprice);

//		PurDrugMed drugMed = new PurDrugMed();
//		drugMed.setLingshouz(lingshou);
//		drugMed.setChengbeiz(chengbei);
//		drugMed.setJiaShijan(effectivedate);	
		List drugMeds= null;
		drugMeds = new ArrayList();
	
		drugMeds.add("");

		HttpSession session = request.getSession();
		session.setAttribute("zbruku", drugMeds); //要返回List表数据显示记得先把数据转成List，再进行储存，否则用List list = (List) session.getAttribute("zbruku");读取不了的
		}
	
	/**
	 * 读取session
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Selectzbruku(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			int totalRows = 0;
			//读取zbruku 存进session的数据
			List list = (List) session.getAttribute("zbruku");
			if(list != null){
			totalRows = list.size();
			}
			User layuiTableData=new User();
			layuiTableData.setI(totalRows);
			

			JSONObject jsonObject = JSONObject.fromObject(layuiTableData);
			PrintWriter out=response.getWriter();
			out.write(jsonObject.toString());
			System.out.println(jsonObject.toString());
			out.flush();
			out.close();
			}
}
