package org.purchasenear.service.ticket.spring;

import java.util.List;

import org.purchasenear.domain.TbOrder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * TicketOrderService的Spring实现类，主要是数据库事务操作
 * 
 * @author wuzhih
 * 
 */
@Component
@Lazy(true)
public class TicketOrderServiceSpringImpl {
	private org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(TicketOrderServiceSpringImpl.class);
	

	public boolean createOrder(TbOrder theOrder) {
		logger.info("create order ..." + theOrder);
		/*Session curSesion = sessionFact.getCurrentSession();
		curSesion.save(theOrder);*/
		logger.info("success created ,id " + theOrder.getId());
		return true;

	}

	@SuppressWarnings("unchecked")
	public List<TbOrder> queryMyOrders(String phoneNum) {
		/*Session curSesion = sessionFact.getCurrentSession();
		String sql = "   from TBOrder  WHERE phone =:phone order by orderDate  desc";
		Query query = curSesion.createQuery(sql);
		query.setParameter("phone", phoneNum);
		return query.list();*/
		return null;
	}

	public boolean cancelOrder(long orderId) {
		/*Session curSesion = sessionFact.getCurrentSession();
		String sql = "  update TBOrder set orderStatus=-1  WHERE  id =:id and orderStatus in (0,1)";
		Query query = curSesion.createQuery(sql);
		query.setParameter("id", orderId);
		int result = query.executeUpdate();
		return (result == 1);*/
		return false;
	}
}
