package org.purchasenear.service.ticket.impl;

import org.purchasenear.common.ice.server.AbstractIceBoxService;

public class TicketService extends AbstractIceBoxService {

	@Override
	public Ice.Object createMyIceServiceObj(String[] args) {
		// 创建servant 并返回
		Ice.Object object = new TicketServiceI();
		return object;
	}
	public void stop() {
		
	}
}
