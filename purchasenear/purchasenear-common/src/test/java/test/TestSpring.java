package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.purchasenear.domain.TbOrder;
import org.purchasenear.service.ticket.spring.TicketOrderServiceSpringImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	@Test
	public void testAll() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TicketOrderServiceSpringImpl springOrderSvrImp = context
				.getBean(TicketOrderServiceSpringImpl.class);
		TbOrder theOrder = new TbOrder();
		theOrder.setPhone("13916969166");
		theOrder.setAmount(33.33);
		theOrder.setOrderDate(2015032701);
		theOrder.setOrderNum("2015032701001");
		boolean success = springOrderSvrImp.createOrder(theOrder);
		assertEquals(true, success);

		List<TbOrder> orders = springOrderSvrImp.queryMyOrders("13916969166");
		assertEquals(true, !orders.isEmpty());

		theOrder = orders.iterator().next();
		success = springOrderSvrImp.cancelOrder(theOrder.getId());
		assertEquals(true, success);
	}

}
