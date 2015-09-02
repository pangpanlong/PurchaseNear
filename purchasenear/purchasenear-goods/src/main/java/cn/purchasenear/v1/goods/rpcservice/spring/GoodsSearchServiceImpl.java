package cn.purchasenear.v1.goods.rpcservice.spring;

import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.lang3.StringUtils;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import cn.purchasenear.v1.goods.consts.ElasticSearchTypeEnum;
import cn.purchasenear.v1.goods.domain.GoodsInfoVO;
import cn.purchasenear.v1.goods.domain.SearchGoodsVO;
import cn.purchasenear.v1.goods.domain.SearchInfoVO;
import cn.purchasenear.v1.goods.service.GoodsSearchService;



@Component
@Lazy(true)
public class GoodsSearchServiceImpl implements GoodsSearchService{
	
	private static SearchGoodsVO searchGoodsVO = new SearchGoodsVO();
	private Logger logger = Logger.getLogger(getClass()); 
	ThreadLocal<String> id = new ThreadLocal<String>();
	public SearchGoodsVO searhGoods(SearchInfoVO info){
		if (id.get() == null) {
			id.set(UUID.randomUUID().toString().replace("-", ""));
		}
		logger.debug("ID["+id.get()+"],SearchInfoVO搜索条件：" + info);
		//2.检查参数是否合法：是否必填先，是否参数不合法
		//3.根据条件封装es条件和过滤规则
		TransportClient client = ElasticSearchClient.getClient();
		SearchRequestBuilder builder = 
				client.prepareSearch(ElasticSearchTypeEnum.GOODS.getIndex())
				.setTypes(ElasticSearchTypeEnum.GOODS.getType());
		builder.setSearchType(SearchType.DEFAULT);
		
		BoolQueryBuilder sBoolQueryBuilder = QueryBuilders.boolQuery();
		
		//构建搜索条件
		buildSearchCondition(sBoolQueryBuilder, info);

		
		//地理位置查询：
		FilterBuilder filterBuilder = FilterBuilders.geoDistanceFilter("locations")  
				.point(info.getLatitude(),info.getLongitude())
				.distance(info.getDistance(), DistanceUnit.METERS)  
				.optimizeBbox("memory")
				.geoDistance(GeoDistance.ARC); 
		
		
		QueryBuilder queryBuilder = 
				QueryBuilders.filteredQuery(sBoolQueryBuilder,filterBuilder);
		logger.info("ID["+id.get()+"],ES search expression: " + queryBuilder.toString());
		builder.setQuery(queryBuilder);
		
		//构建排序字段
		buildSort(builder, info);
		
		//构建分页
		buildSearchPage(builder, info);
    	
    	//开始执行查询：
		SearchResponse response =  builder.execute().actionGet(); 
		SearchHits hits = response.getHits();
		logger.info("ID["+id.get()+"],search resultset.size=" + hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        GoodsInfoVO[] goods = new GoodsInfoVO[searchHists.length];
        if(searchHists.length>0){
        	int i = 0;
            for(SearchHit hit:searchHists){
                GoodsInfoVO goodsInfo = new GoodsInfoVO();
                goodsInfo.copy(hit);
                goods[i] = goodsInfo;
                i++;
                logger.debug("ID["+id.get()+"],search result:"+goodsInfo);
            }
        }
		
		//5.对结果封装成SearchGoods
		SearchGoodsVO searchGoodsVO = new SearchGoodsVO();
		searchGoodsVO.copyFromInfo(info);
		searchGoodsVO.setGoodsList(goods);
		
		return searchGoodsVO;
		
	}

	private void buildSearchPage(SearchRequestBuilder builder, SearchInfoVO info) {
		//分页：
		int page = 0;
		int pageSize = 10;
		if(info.getPage()>0){
			page = info.getPage();
		}
		if(info.getPageSize()>0){
			pageSize = info.getPageSize();
		}
		info.setPage(page);
		info.setPageSize(pageSize);
    	builder.setFrom(page).setSize(pageSize);
	}

	private void buildSort(SearchRequestBuilder builder, SearchInfoVO info) {
		/**排序：
		•	price	boolean	false	是否以商品价格排序，默认false
		•	saled	boolean	false	是否以销量排序，默认false
		•	browsed	boolean	false	是否以浏览量排序，默认false
		*/
		if(info.isPrice()){
			builder.addSort("price",SortOrder.ASC) ;// Query
		}else if(info.isSaled()){
			builder.addSort("saleCount",SortOrder.DESC) ;// Query
		}else if(info.isBrowsed()){
			builder.addSort("browseCount",SortOrder.DESC) ;// Query
		}
	}

	private void buildSearchCondition(BoolQueryBuilder sBoolQueryBuilder,
			SearchInfoVO info) {
		//模糊查询：goodsName and sellerName
		if(!StringUtils.isEmpty(info.getGoodsName())){
			sBoolQueryBuilder.must(QueryBuilders.fuzzyQuery("goodsName", "*"+info.getGoodsName()+"*"));
		}
		if(!StringUtils.isEmpty(info.getSellerName())){
			sBoolQueryBuilder.must(QueryBuilders.fuzzyQuery("sellerName", "*"+info.getSellerName()+"*"));
		}
		
		//GoodsCategory支持多种商品类型查询
		if(!StringUtils.isEmpty(info.getGoodsCategory())){
			sBoolQueryBuilder.must(QueryBuilders.inQuery("goodsCategory", info.getGoodsCategory().split(",")));
		}
		//品牌支持多种查询
		if(!StringUtils.isEmpty(info.getBrand())){
			sBoolQueryBuilder.must(QueryBuilders.inQuery("brandId", info.getBrand().split(",")));
		}
		
		/**lowPrice and highPrice*/
		if(info.getLowPrice()>0){ //查询的商品价格不低于此值: >=
			sBoolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(info.getLowPrice()));
		}
		if(info.getHighPrice()>0){//查询的商品价格不高于此值: <=
			sBoolQueryBuilder.must(QueryBuilders.rangeQuery("price").lte(info.getHighPrice()));
		}
		
		//hypostatic 
		if(info.getHypostatic()!=0){
			sBoolQueryBuilder.must(QueryBuilders.matchQuery("hypostatic", info.getHypostatic()));
		}
		
		//deliver 
		if(info.getDeliver()!=0){
			sBoolQueryBuilder.must(QueryBuilders.matchQuery("deliver", info.getDeliver()));
		}
		//secondHand 
		if(info.getSecond_hand()!=0){
			sBoolQueryBuilder.must(QueryBuilders.matchQuery("secondHand", info.getSecond_hand()));
		}
		//barter 
		if(info.getBarter()!=0){
			sBoolQueryBuilder.must(QueryBuilders.matchQuery("barter", info.getBarter()));
		}
	}
	
	public static void main(String[] args) {
		ElasticSearchClient.initClient("localhost:9300", "elasticsearch");
		SearchInfoVO req = new SearchInfoVO();
		req.setLatitude(50);
		req.setLongitude(50);
		req.setDistance(1000);
		req.setGoodsCategory("1,2,3");
		req.setLowPrice(50);
		req.setHighPrice(100);
		req.setBarter(1);
		req.setHypostatic(1);
		req.setSecond_hand(1);
		req.setDeliver(1);
		//分页查询
		req.setPage(0);
		req.setPageSize(10);
		
		//req.setPrice(true);
		//req.setSaled(true);
		//req.setBrowsed(true);
		System.out.println(new GoodsSearchServiceImpl().searhGoods(req));
	}
	
}
