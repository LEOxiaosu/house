package com.hoursecy.sy.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.common.exception.ServiceException;
import com.hoursecy.common.util.PageUtil;
import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.dao.ForSellMapper;
import com.hoursecy.sy.pojo.ForSellPojo;
import com.hoursecy.sy.service.ForSellService;

@Service
public class ForSellServiceImpl implements ForSellService{

	@Autowired 
	private ForSellMapper sellDao;

	/**
	 * 获取总记录数
	 */
	public int getRowCount(ForSellPojo sells){
		int rows = sellDao.getRowCount(sells);
		return rows;
	}
	@Override
	public PageObject<ForSellPojo> findAllObjects(ForSellPojo sells,Integer pageCurrent) {
		//1.判断当前页数的合法性
		if(pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("当前页码值不正确");
		}
		//2.对总记录数进行一个判断
		int rowCount = sellDao.getRowCount(sells);
		if(rowCount==0){
			throw new ServiceException("没有找到对应的记录");//自定义异常
		}
		//3.查询当前页日志记录
		int pageSize=3;  //每页显示3条数据
		int startIndex=(pageCurrent-1)*pageSize; //起始页码

		//4.查询页码范围内的所有满足条件的记录
		String provence = sells.getProvence();//省
		String city = sells.getCity(); //市
		String place = sells.getPlace();//区/县
		int room = sells.getRoom();//室
		int door=sells.getDoor();//厅
		String pricetype =sells.getPricetype();//支付方式
		String minprice = sells.getMinprice();//最低价
		String maxprice =sells.getMaxprice();//最高价
		//此方法用于分页获取满足条件的记录
		List<ForSellPojo> records=sellDao.findAllObjects(provence,city,place,
				room,door,pricetype,minprice,maxprice,startIndex, pageSize);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//转换所有的时间格式
		for(ForSellPojo sell:records ){
			String date = simpleDateFormat.format(sell.getIssuetime()); 
			//将数据库中读取的时间转换为为年/月/日字符串，存入date成员变量中，在前端获取date显示时间
			sell.setDate(date);  
		}
		//5.对查询结果进行封装并返回
		return PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
	}
	@Override
	public PageObject<ForSellPojo> doFindRecommend(ForSellPojo sells, Integer pageCurrent) {
		//1.判断当前页数的合法性
		if(pageCurrent==null||pageCurrent<1){
			throw new IllegalArgumentException("当前页码值不正确");
		}
		//2.对总记录数进行一个判断
		int rowCount = sellDao.getRowCount(sells);
		if(rowCount==0){
			throw new ServiceException("没有找到对应的记录");//自定义异常
		}
		//3.查询当前页日志记录
		int pageSize=3;  //每页显示3条数据
		int startIndex=(pageCurrent-1)*pageSize; //起始页码

		//4.查询页码范围内的所有满足条件的记录
		String provence = sells.getProvence();//省
		String city = sells.getCity(); //市
		String place = sells.getPlace();//区/县
		List<ForSellPojo> records=sellDao.doFindRecommend(provence,city,place,
				startIndex, pageSize);
		//5.对查询结果进行封装并返回
		return PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
	}
}
