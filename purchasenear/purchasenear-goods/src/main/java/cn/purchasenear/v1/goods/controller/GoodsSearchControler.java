package cn.purchasenear.v1.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.purchasenear.v1.goods.domain.SearchGoodsVO;
import cn.purchasenear.v1.goods.domain.SearchInfoVO;
import cn.purchasenear.v1.goods.service.GoodsSearchService;

public class GoodsSearchControler {

	private GoodsSearchService goodsSearchService;

	@RequestMapping(value="/goods/search",method=RequestMethod.POST)
	public SearchGoodsVO search(SearchInfoVO info){

		return goodsSearchService.searhGoods(info);
	}

}
