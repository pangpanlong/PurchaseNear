package cn.purchasenear.v1.goods.rpcservice.ice;

import org.purchasenear.common.ice.server.AbstractIceBoxService;

import cn.purchasenear.v1.goods.rpcservice.ice.impl.GoodsSearchIceServiceI;

@SuppressWarnings("serial")
public class GoodsSearchIceService extends AbstractIceBoxService {

	@Override
	public Ice.Object createMyIceServiceObj(String[] args) {
		// 创建servant 并返回
		Ice.Object object = new GoodsSearchIceServiceI();
		return object;
	}
	public void stop() {
		
	}

}
