package cn.purchasenear.v1.cart.service.impl;

import cn.purchasenear.v1.cart.dao.PurchaseCartDao;
import cn.purchasenear.v1.cart.domain.PurchaseCart;
import cn.purchasenear.v1.cart.service.PurchaseCartService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:Pengd
 * @Date:2015/8/31 12:17 Copyright (c) 2014, liangceNetwork All Rights Reserved.
 */
@Service("purchaseCartService")
public class PurchaseCarServiceImpl implements PurchaseCartService {

	final static Logger logger = LoggerFactory.getLogger(PurchaseCarServiceImpl.class);

	@Resource
	PurchaseCartDao purchaseCartDao;

	@Override
	public int addCart(PurchaseCart cart) {
		long current = System.currentTimeMillis();
		int result = 0;
		try {
			result = purchaseCartDao.saveCart(cart);
		} catch (Exception e) {
			logger.debug("插入数据库失败,详细信息为::{}", e);
		}

		long consumed = System.currentTimeMillis() - current;
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("params", JSONObject.toJSON(cart));
		json.put("consumed", consumed);
		logger.info("处理客户端请求完毕，详细信息为:::{}", json.toJSONString());
		return result;
	}
}
