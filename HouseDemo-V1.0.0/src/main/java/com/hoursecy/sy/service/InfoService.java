package com.hoursecy.sy.service;

import java.util.List;

import com.hoursecy.common.vo.JsonResult;
import com.hoursecy.sy.pojo.ForSellPojo;

public interface InfoService extends PageService {

	ForSellPojo doFindObjectById(Integer houseid);

	int deleteObject(Integer houseid);
	JsonResult alterData(ForSellPojo alter);
}
