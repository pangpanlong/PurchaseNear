package cn.purchasenear.v1.cart.ice.impl;

import Ice.Current;
import cn.purchasenear.v1.cart.domain.PurchaseCart;
import cn.purchasenear.v1.cart.ice.interf.CartInfo;
import cn.purchasenear.v1.cart.ice.interf.OpCartInfo;
import cn.purchasenear.v1.cart.ice.interf._CartServiceDisp;
import cn.purchasenear.v1.cart.service.impl.PurchaseCarServiceImpl;
import org.purchasenear.common.util.SpringUtil;

import java.util.Date;

/**
 * @Author:Pengd
 * @Date:2015/8/31 12:31 Copyright (c) 2014, liangceNetwork All Rights Reserved.
 */
public class PurchaseCartIceServiceI extends _CartServiceDisp {

	@Override
	public OpCartInfo addCart(CartInfo info, Current __current) {
		OpCartInfo opCartInfo = new OpCartInfo();
		PurchaseCart cart = new PurchaseCart();
		cart.setUserId(info.userId);
		cart.setGoodsId(info.goodsId);
		cart.setAmount(info.amount);
		cart.setAddTime(new Date());
		opCartInfo.status = SpringUtil.getBean(PurchaseCarServiceImpl.class).addCart(cart) > 0 ? 1 : 0;
		return opCartInfo;
	}
}
