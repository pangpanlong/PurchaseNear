package cn.purchasenear.v1.cart.domain;

import java.util.Date;

/**
 * @Author:Pengd
 * @Date:2015/8/31 12:05 Copyright (c) 2014, liangceNetwork All Rights Reserved.
 */
public class PurchaseCart {

	private Long id;
	private Long userId;
	private Long goodsId;
	private Integer amount;
	private Date addTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
