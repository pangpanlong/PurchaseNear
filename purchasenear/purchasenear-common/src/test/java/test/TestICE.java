package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.purchasenear.common.ice.client.ICEClientUtil;
import org.purchasenear.service.ticket.interf.Order;
import org.purchasenear.service.ticket.interf.TicketServicePrx;

public class TestICE {

	@Test
	public void testCall() {
		TicketServicePrx ticketServicePrx = (TicketServicePrx) ICEClientUtil
				.getSerivcePrx(TicketServicePrx.class);
		Order[] orders = ticketServicePrx.queryMyOrders("13916969166");
		assertEquals(true, orders.length > 1);
	}
}
