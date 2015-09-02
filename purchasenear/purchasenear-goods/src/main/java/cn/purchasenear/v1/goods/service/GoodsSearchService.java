package cn.purchasenear.v1.goods.service;

import cn.purchasenear.v1.goods.domain.SearchGoodsVO;
import cn.purchasenear.v1.goods.domain.SearchInfoVO;

public interface GoodsSearchService {

	public SearchGoodsVO searhGoods(SearchInfoVO info);

}
