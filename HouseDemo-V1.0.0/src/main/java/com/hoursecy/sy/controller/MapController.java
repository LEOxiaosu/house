package com.hoursecy.sy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoursecy.sy.pojo.MapPojo;

@Controller
public class MapController {
	@RequestMapping("/poimap")
	public String map(){
		return "poimap";
	}
}
