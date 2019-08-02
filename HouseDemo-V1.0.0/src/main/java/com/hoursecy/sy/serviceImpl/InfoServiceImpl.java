package com.hoursecy.sy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.common.exception.ServiceException;
import com.hoursecy.common.util.PageUtil;
import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.dao.ForRentMapper;
import com.hoursecy.sy.dao.InfoDao;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.InfoService;
@Service
public class InfoServiceImpl implements InfoService{
	@Autowired
	private InfoDao infoDao;
	@Autowired
	private ForRentMapper forRentMapper;
	@Override
	public PageObject findPageObjects(Integer id, Integer pageCurrent) {
		//1.判定pageCurrent参数合法性
		
				if(pageCurrent==null||pageCurrent<1) 
				throw new IllegalArgumentException("当前页码值不正确");
				//2.查询日志总记录数,并进行判定
				int rowCount=infoDao.getRows(id);
				if(rowCount==0);				//3.查询当前页日志记录
				int pageSize=PageUtil.getPageSize();
				int startIndex=PageUtil.geStartIndex(pageCurrent);
				List<ForSellPojo> records=infoDao.findPageObjects(id,startIndex, pageSize);
				//4.对查询结果进行封装并返回
				return PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
	}
	@Override
	public ForSellPojo doFindObjectById(Integer houseid) {
		if(houseid==null||houseid<1) {
			throw new IllegalArgumentException("没有对应id值");
		}
		ForSellPojo df = infoDao.doFindObjectById(houseid);
		if(df==null) {
			throw new ServiceException("没有对应记录");
		}
		return df;
	}
	@Override
	public int deleteObject(Integer houseid) {
		int row = infoDao.deleteObjects(houseid);
		if(row==0) {
			throw new ServiceException("数据可能已经不存在");
		}
		return row;
	}
	@Override
	public JsonResult alterData(ForSellPojo alter) {
		infoDao.alterData(alter);
		return new JsonResult("更新完成");
	}

}
