package com.hoursecy.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.ForSellService;

@Controller
public class ForSellController {
	@Autowired 
	ForSellService forSellService;
	/** 加载卖房界面*/
	@RequestMapping("/forsale")
	public String forSell() {
		return "forsale";
	}
	/** 加载卖房数据*/
	@RequestMapping("/doFindPageObject")
	@ResponseBody
	public JsonResult doFindObjects(ForSellPojo sells,Integer pageCurrent) {
		try {
			PageObject<ForSellPojo> pageObject = forSellService.findAllObjects(sells, pageCurrent);
			return new JsonResult(pageObject);
		} catch (Exception e) {
			return new JsonResult(e);//捕获异常
		}
	}
	
	@RequestMapping("/doFindRecommend")
	@ResponseBody
	public JsonResult doFindRecommend(ForSellPojo sells,Integer pageCurrent) {
		try {
			PageObject<ForSellPojo> pageObject = forSellService.doFindRecommend(sells, pageCurrent);
			return new JsonResult(pageObject);
		} catch (Exception e) {
			return new JsonResult(e);//捕获异常
		}
	}
}
