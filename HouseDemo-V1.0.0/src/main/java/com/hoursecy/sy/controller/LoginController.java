package com.hoursecy.sy.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping("LoginPhone")
	@ResponseBody
	public HashMap LoginPhone(HttpServletRequest request) {
		String result = loginService.PhoneIsExist(request.getParameter("phone"));
		HashMap<String, String> map = new HashMap<>();
		map.put("result", result);
		return map;
	}

	@RequestMapping("Login")
	@ResponseBody
	public UserPojo Login(String phone,String password,HttpServletRequest request,HttpServletResponse response) throws IOException {

		UserPojo user = new UserPojo();
		if(phone==""||password=="") {
			System.out.println("-----------------");
			return user;
		}
		user=loginService.accountPasswordExists(phone, password);
		/*Cookie idCookie = new Cookie("userId",String.valueOf(user.getId()));
		System.out.println(idCookie.toString());
		response.addCookie(idCookie);
		response.sendRedirect("myInfo.html");*/
		return user;
	}

}
