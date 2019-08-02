package com.hoursecy.sy.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.service.IssueRentService;


@Controller
public class IssueRentController {
	@Autowired	//由spring创建实例并为变量赋值
	IssueRentService issueRentService;
	
	
	@RequestMapping("issueRent")
	public String issueRent(){
		//转向 查询所有订单的方法
		return "issueRent";
	}
	
	@RequestMapping("frm")
	public String IssueRentAdd(ForRentPojo forrentpojo){
		try {
			//1.调用OrderService的addOrder方法,添加订单信息
			int rows = issueRentService.addrenthouse(forrentpojo);
			Date date = new Date();
			System.out.println(date);
			forrentpojo.setIssuetime(date);
			//转向 查询所有订单的方法
			
		} catch (Exception e) {
		}
		return "forward:/";
	}
}
