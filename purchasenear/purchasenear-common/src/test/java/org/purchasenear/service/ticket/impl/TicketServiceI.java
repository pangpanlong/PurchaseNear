package org.purchasenear.service.ticket.impl;

import java.util.List;

import org.purchasenear.common.util.SpringUtil;
import org.purchasenear.domain.TbOrder;
import org.purchasenear.service.ticket.interf.Order;
import org.purchasenear.service.ticket.interf._TicketServiceDisp;
import org.purchasenear.service.ticket.spring.TicketOrderServiceSpringImpl;
import org.slf4j.LoggerFactory;

import Ice.Current;

public class TicketServiceI extends _TicketServiceDisp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	org.slf4j.Logger logger = LoggerFactory.getLogger(TicketServiceI.class);

	@Override
	public boolean createOrder(Order myOrder, Current __current) {
		TbOrder tbOrder = new TbOrder();
		tbOrder.setPhone(myOrder.phone);
		tbOrder.setOrderDate(myOrder.orderDate);
		tbOrder.setOrderNum(myOrder.orderNum);
		tbOrder.setTicketType(myOrder.ticketType);
		tbOrder.setAmount(myOrder.amount);
		tbOrder.setOrderStatus(0);
		return SpringUtil.getBean(TicketOrderServiceSpringImpl.class)
				.createOrder(tbOrder);
	}

	@Override
	public Order[] queryMyOrders(String phone, Current __current) {
		List<TbOrder> tbOrders = SpringUtil.getBean(
				TicketOrderServiceSpringImpl.class).queryMyOrders(phone);
		Order[] orders = new Order[tbOrders.size()];
		int i = 0;
		for (TbOrder tbOder : tbOrders) {
			orders[i++] = tBOrder2Order(tbOder);
		}
		return orders;
	}

	private static Order tBOrder2Order(TbOrder tbOder) {
		Order order = new Order(tbOder.getId(), tbOder.getPhone(),
				tbOder.getOrderNum(), tbOder.getOrderDate(),
				tbOder.getTicketType(), tbOder.getAmount(),
				tbOder.getOrderStatus());
		return order;
	}

	@Override
	public boolean cancelOrder(long orderId, Current __current) {
		return SpringUtil.getBean(TicketOrderServiceSpringImpl.class)
				.cancelOrder(orderId);
	}

}
