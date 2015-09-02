package cn.purchasenear.v1.goods.service.impl;

import org.purchasenear.common.ice.client.ICEClientUtil;
import org.springframework.stereotype.Service;

import cn.purchasenear.v1.goods.domain.SearchGoodsVO;
import cn.purchasenear.v1.goods.domain.SearchInfoVO;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.GoodsSearchServicePrx;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchGoods;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchInfo;
import cn.purchasenear.v1.goods.service.GoodsSearchService;

@Service("goodsSearchService")
public class GoodsSearchServiceImpl implements GoodsSearchService{
	
	
	public SearchGoodsVO searhGoods(SearchInfoVO info){
		GoodsSearchServicePrx servicePrx = (GoodsSearchServicePrx) ICEClientUtil
				.getSerivcePrx(GoodsSearchServicePrx.class);
		SearchInfo req = new SearchInfo();
		info.to(req);
		SearchGoods result = servicePrx.search(req);
		SearchGoodsVO resp = new SearchGoodsVO();
		resp.copy(result);
		return resp;
		
	}

}
