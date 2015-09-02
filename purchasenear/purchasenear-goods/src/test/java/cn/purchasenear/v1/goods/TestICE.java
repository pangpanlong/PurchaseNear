package cn.purchasenear.v1.goods;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.purchasenear.common.ice.client.ICEClientUtil;

import cn.purchasenear.v1.goods.domain.SearchInfoVO;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.GoodsSearchServicePrx;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchGoods;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchInfo;

public class TestICE {

	@Test
	public void testCall() {
		GoodsSearchServicePrx servicePrx = (GoodsSearchServicePrx) ICEClientUtil
				.getSerivcePrx(GoodsSearchServicePrx.class);
		SearchInfo info = new SearchInfo();
		info.latitude=50;
		info.longitude=50;
		info.distance=1000;
	/*	req.setGoodsCategory("1,2,3");
		req.setLowPrice(50);
		req.setHighPrice(100);
		req.setBarter(1);
		req.setHypostatic(1);
		req.setSecond_hand(1);
		req.setDeliver(1);*/
		/*//分页查询
		req.setPage(0);
		req.setPageSize(10);*/
		SearchGoods result = servicePrx.search(info);
		System.out.println(result.goodsList.length);
		assertEquals(true, result.goodsList.length==2);
	}
}
