package com.hoursecy.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.ForRentService;

@Controller
public class ForRentController {
	
	@Autowired 
	ForRentService forrentService;
	
	@RequestMapping("/forRent")
	public String forRent(){
		return "forRent";
	}
	
	/** 查询页面加载时需要显示的默认初始条件的租房信息*/
	@RequestMapping("/doRentObjects")
	@ResponseBody
	public JsonResult doRentObjects(ForRentPojo rents,Integer pageCurrent ){
		try {
			PageObject<ForRentPojo> pageObject = forrentService.findRentObjects(rents,pageCurrent);
			return new JsonResult(pageObject);
		} catch (Exception e) {
			return new JsonResult(e);
		}
	}
}
