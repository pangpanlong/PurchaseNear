package cn.purchasenear.v1.cart.dao;

import cn.purchasenear.v1.cart.domain.PurchaseCart;

/**
 * @Author:Pengd
 * @Date:2015/8/31 12:00 Copyright (c) 2014, liangceNetwork All Rights Reserved.
 */
public interface PurchaseCartDao {
	public int saveCart(PurchaseCart cart) throws Exception;
}
