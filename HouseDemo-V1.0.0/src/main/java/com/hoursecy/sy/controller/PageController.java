package com.hoursecy.sy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {	
	@RequestMapping("/doPageUI")
	public String doPageUI() {
		return "page";
	}
	@RequestMapping("/doPageUI2")
	public String doPageUI2() {
		return "page2";
	}
}
