package com.hoursecy.sy.service;

import com.hoursecy.common.vo.PageObject;
import com.hoursecy.sy.pojo.ForRentPojo;

public interface ForRentService {
	PageObject<ForRentPojo> findRentObjects(ForRentPojo forRentPojo, Integer pageCurrent);
}
