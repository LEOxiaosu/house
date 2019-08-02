package com.hoursecy.sy.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoursecy.common.vo.HouseOwner;
import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.DetaiInfoService;

@Controller
public class DetaiInfoController {
	
	@Autowired
	private DetaiInfoService detaiInfoService;
	
	@RequestMapping("/detailInfo")
	public String detailInfo() {
		return "detailInfo";
	}
	
	@RequestMapping("/xxjmzf")
	public String xxjmzf() {
		return "xxjmzf";
	}
	
	@PostMapping("findHouseById")
	@ResponseBody
	public JsonResult findHouseById(Integer id) {
		// 根据房屋id查询房屋详情信息
		ForSellPojo sellhouse = detaiInfoService.findSellhouseById(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = simpleDateFormat.format(sellhouse.getIssuetime());
		sellhouse.setDate(date);
		// 根据房屋id查询该房屋的用户信息
		UserPojo user = detaiInfoService.findUserById(id);
		// 把用户信息重新封装
		HouseOwner houseOwner = new HouseOwner(user);
		// 把两个查询结果封装到list集合中
		Map<String,Object> map = new HashMap();
		map.put("sellhouse", sellhouse);
		map.put("user", houseOwner);
		// 封装成json格式返回
		JsonResult js = new JsonResult(map);
		return js;
	}
	
	@PostMapping("findRentHouseById")
	@ResponseBody
	public JsonResult findRentHouseById(Integer id) {
		ForRentPojo rentHouse = detaiInfoService.findRentHouseById(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = simpleDateFormat.format(rentHouse.getIssuetime());
		String waterelet;
		if(rentHouse.getWaterelet()!=0) {
			waterelet="包水电";
		}else {
			waterelet="不包水电";
		}
		// 根据房屋id查询该房屋的用户信息
		UserPojo user = detaiInfoService.findUserById(id);
		// 把用户信息重新封装
		HouseOwner houseOwner = new HouseOwner(user);
		// 把两个查询结果封装到list集合中
		Map<String,Object> map = new HashMap();
		map.put("House",rentHouse);
		map.put("user", houseOwner);
		map.put("date", date);
		map.put("waterelet", waterelet);
		// 封装成json格式返回
		JsonResult js = new JsonResult(map);
		return js;

	}
	
	
}
