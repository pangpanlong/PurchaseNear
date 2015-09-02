package org.purchasenear.service.ticket.spring;

import java.util.List;

import org.purchasenear.domain.TbOrder;

public interface TicketOrderServiceSpringI {
	public boolean createOrder(TbOrder myOrder);
	public List<TbOrder> queryMyOrders(String phoneNum);
	public boolean cancelOrder(long orderId);
}
