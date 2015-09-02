package cn.purchasenear.v1.goods.rpcservice.ice.impl;

import org.purchasenear.common.util.SpringUtil;

import Ice.Current;
import Ice.Properties;
import cn.purchasenear.v1.goods.domain.SearchGoodsVO;
import cn.purchasenear.v1.goods.domain.SearchInfoVO;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchGoods;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchInfo;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods._GoodsSearchServiceDisp;
import cn.purchasenear.v1.goods.rpcservice.spring.ElasticSearchClient;
import cn.purchasenear.v1.goods.rpcservice.spring.GoodsSearchServiceImpl;

@SuppressWarnings("serial")
public class GoodsSearchIceServiceI extends _GoodsSearchServiceDisp{
	private static SearchInfoVO searchInfoVO = new SearchInfoVO();
	private static SearchGoods searchGoods = new SearchGoods();
	
	@SuppressWarnings("static-access")
	@Override
	public SearchGoods search(SearchInfo info, Current __current) {
		initESClient(__current);
		GoodsSearchServiceImpl service =SpringUtil.getBean(GoodsSearchServiceImpl.class);
		SearchInfoVO searchInfoVO = (SearchInfoVO)this.searchInfoVO.clone();
		searchInfoVO.copy(info);
		SearchGoodsVO  result = service.searhGoods(searchInfoVO);
		SearchGoods searchGoods = (SearchGoods)this.searchGoods.clone();
		result.to(searchGoods);
		return searchGoods;
	}
	
	private void initESClient(Current __current){
		if(ElasticSearchClient.getClient() ==null){
			Properties properties = __current.adapter.getCommunicator().getProperties();
			String clusterNodes = properties.getPropertyWithDefault("clusterNodes","localhost:9300");
			String clusterName = properties.getPropertyWithDefault("clusterName", "elasticsearch");
			ElasticSearchClient.initClient(clusterNodes, clusterName);
		}
	}
	
	public static void main(String[] args) {
		SearchInfo info = new SearchInfo();
		info.goodsName="bbbb";
		new GoodsSearchIceServiceI().search(info, null);
	}

}
