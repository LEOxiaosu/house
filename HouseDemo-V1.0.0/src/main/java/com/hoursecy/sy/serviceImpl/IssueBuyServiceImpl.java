package com.hoursecy.sy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.sy.dao.IssueBuyMapper;

import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.IssueBuyService;
@Service
public class IssueBuyServiceImpl implements IssueBuyService{
	@Autowired IssueBuyMapper issueBuyMapper;
	@Override
	public int addrenthouse(ForSellPojo forsellpojo) {
		int row = issueBuyMapper.addbuyhouse(forsellpojo);
		return row;
	}
}
