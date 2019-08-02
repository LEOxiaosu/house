package com.hoursecy.sy.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.InfoService;

@Controller
public class InfoController {
	@Autowired
	private InfoService infoService;
	@RequestMapping("contact")
	public String Info() {
		return "myInfo";
	}
	@RequestMapping("index")
	public String ss() {
		return "index";
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer id,Integer pageCurrent) {
		PageObject<ForSellPojo> pageObject=infoService.findPageObjects(2,pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer houseid) {
		try {
			return new JsonResult(infoService.doFindObjectById(houseid));
		} catch (Exception e) {
			return new JsonResult(e);
		}
	}
	@RequestMapping("update")
	public String updata() {
		return "infoedit";
	}
	@RequestMapping("doDelete")
	@ResponseBody
	public JsonResult doDeleteObject(Integer houseid) {
		infoService.deleteObject(houseid);
		return new JsonResult("删除完成");	
	}
	@RequestMapping("alterData")
	@ResponseBody
	public JsonResult alter(ForSellPojo alter) {
		infoService.alterData(alter);
		return new JsonResult("更新完成");
	}
}
