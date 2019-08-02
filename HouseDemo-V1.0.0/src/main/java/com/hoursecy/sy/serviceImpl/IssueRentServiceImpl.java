package com.hoursecy.sy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.sy.dao.IssueRentMapper;
import com.hoursecy.sy.pojo.ForRentPojo;
import com.hoursecy.sy.service.IssueRentService;
@Service
public class IssueRentServiceImpl implements IssueRentService{
	@Autowired IssueRentMapper issueRentMapper;
	@Override
	public int addrenthouse(ForRentPojo forrentpojo) {
		// TODO Auto-generated method stub
		int row = issueRentMapper.addrenthouse(forrentpojo);
		return row;
	}

}
