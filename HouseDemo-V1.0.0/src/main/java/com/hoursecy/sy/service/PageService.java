package com.hoursecy.sy.service;

import com.hoursecy.common.vo.PageObject;

public interface PageService<T> {
	PageObject<T> findPageObjects(Integer id,Integer pageCurrent);
}
