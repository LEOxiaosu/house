package com.hoursecy.common.util;

import java.util.List;

import com.hoursecy.common.vo.PageObject;
public class PageUtil {
	private static int pageSize=3;
	public static int getPageSize() {
		return pageSize;
	}
	public static int geStartIndex(Integer pageCurrent) {
		return (pageCurrent-1)*pageSize;
	}
	public static <T>PageObject<T> newPageObject(Integer pageCurrent, int rowCount, int pageSize, List<T> records) {
		PageObject<T> po=new PageObject<T>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);
		return po;
	}
}
