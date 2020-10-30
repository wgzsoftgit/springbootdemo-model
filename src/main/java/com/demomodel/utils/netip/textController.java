package com.demomodel.utils.netip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("getip")
public class textController {

	@RequestMapping("ip")
	@ResponseBody
	public String getipText(HttpServletRequest request) {
		String clinetIpByReq = IpUtil.getClinetIpByReq(request);
		System.err.println(clinetIpByReq);
		String realIP = IpUtil.getRealIP(request);
		System.err.println(realIP);
		return "ok";
		
	}
}
