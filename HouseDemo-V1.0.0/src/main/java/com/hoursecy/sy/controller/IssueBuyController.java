package com.hoursecy.sy.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.IssueBuyService;

@Controller
public class IssueBuyController {
	@Autowired
	IssueBuyService IssueBuyService;
	
	@RequestMapping("issueBuy")
	public String issueBuy(){
		//转向 查询所有订单的方法
		return "issueBuy";
	}
	
	@RequestMapping("buyform")
	public String IssueBuyAdd(ForSellPojo forsellpojo){
		try {
			double b=forsellpojo.getPrice()/forsellpojo.getSize();
			forsellpojo.setPreprice(b);
			Date date = new Date();
			forsellpojo.setIssuetime(date);
			System.out.println(forsellpojo);
			//1.调用OrderService的addOrder方法,添加订单信息
			int rows = IssueBuyService.addrenthouse(forsellpojo);
//			System.out.println(rows);
			//转向 查询所有订单的方法
		} catch (Exception e) {
			
		}
		
		return "iplocation";
	}
}
