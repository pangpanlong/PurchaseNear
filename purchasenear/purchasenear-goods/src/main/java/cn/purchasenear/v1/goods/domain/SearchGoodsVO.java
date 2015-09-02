package cn.purchasenear.v1.goods.domain;

import java.io.Serializable;
import java.util.Arrays;

import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.GoodsInfo;
import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchGoods;

public class SearchGoodsVO implements Serializable, Cloneable {

	private int status = 0;

	private int page;

	private GoodsInfoVO[] goodsList;

	private long goodsId;

	private String goodsName;

	private long category;

	private int stock;

	private double logintitude;

	private double latitude;

	private String address;

	private int hypostatic;

	private int deliver;

	private int secondHand;

	private int barter;

	private double distance;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public GoodsInfoVO[] getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsInfoVO[] goodsList) {
		this.goodsList = goodsList;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getLogintitude() {
		return logintitude;
	}

	public void setLogintitude(double logintitude) {
		this.logintitude = logintitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getHypostatic() {
		return hypostatic;
	}

	public void setHypostatic(int hypostatic) {
		this.hypostatic = hypostatic;
	}

	public int getDeliver() {
		return deliver;
	}

	public void setDeliver(int deliver) {
		this.deliver = deliver;
	}

	public int getSecondHand() {
		return secondHand;
	}

	public void setSecondHand(int secondHand) {
		this.secondHand = secondHand;
	}

	public int getBarter() {
		return barter;
	}

	public void setBarter(int barter) {
		this.barter = barter;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public java.lang.Object clone() {
		java.lang.Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			// assert false; // impossible
		}
		return o;
	}
	
	public void copy(SearchGoods searchGoods){
		setStatus(searchGoods.status);
		setPage(searchGoods.page);
		//从GoodsInfo转换VO对象
		GoodsInfo[] vos = searchGoods.goodsList;
		GoodsInfoVO[] infos = new GoodsInfoVO[vos.length];
		for(int i = 0;i < vos.length; i++){
			GoodsInfoVO goods = new GoodsInfoVO();
			goods.from(vos[i]);
			infos[i] = goods;
		}
		
		setGoodsList(infos);
		setGoodsId(searchGoods.goodsId);
		setGoodsName(searchGoods.goodsName);
		setCategory(searchGoods.category);
		setStock(searchGoods.stock);
		setLogintitude(searchGoods.logintitude);
		setLatitude(searchGoods.latitude);
		setAddress(searchGoods.address);
		setHypostatic(searchGoods.hypostatic);
		setDeliver(searchGoods.deliver);
		setSecondHand(searchGoods.secondHand);
		setBarter(searchGoods.barter);
		setDistance(searchGoods.distance);

	}
	
	public void copyFromInfo(SearchInfoVO info){
		setStatus(1);
		setPage(info.getPage());
		//setGoodsList(searchGoods.goodsList);
		//setGoodsId(searchGoods.goodsId);
		//setGoodsName(searchGoods.goodsName);
		//setCategory(searchGoods.category);
		//setStock(searchGoods.stock);
		setLogintitude(info.getLongitude());
		setLatitude(info.getLatitude());
		//setAddress(searchGoods.address);
		setHypostatic(info.getHypostatic());
		setDeliver(info.getDeliver());
		setSecondHand(info.getSecond_hand());
		setBarter(info.getBarter());
		setDistance(info.getDistance());

	}

	public void to(SearchGoods searchGoods) {
		searchGoods.status=getStatus();
		searchGoods.page=getPage();
		GoodsInfoVO[] vos = getGoodsList();
		GoodsInfo[] infos = new GoodsInfo[vos.length];
		for(int i = 0;i < vos.length; i++){
			GoodsInfo goods = new GoodsInfo();
			vos[i].to(goods);
			infos[i] = goods;
		}
		searchGoods.goodsList=infos;
		
		searchGoods.goodsId=getGoodsId();
		searchGoods.goodsName=getGoodsName();
		searchGoods.category=getCategory();
		searchGoods.stock=getStock();
		searchGoods.logintitude=getLogintitude();
		searchGoods.latitude=getLatitude();
		searchGoods.address=getAddress();
		searchGoods.hypostatic=getHypostatic();
		searchGoods.deliver=getDeliver();
		searchGoods.secondHand=getSecondHand();
		searchGoods.barter=getBarter();
		searchGoods.distance=getDistance();
	}

	@Override
	public String toString() {
		return "SearchGoodsVO [status=" + status + ", page=" + page
				+ ",\n goodsList=" + Arrays.toString(goodsList) + ",\n goodsId="
				+ goodsId + ", goodsName=" + goodsName + ", category="
				+ category + ", stock=" + stock + ", logintitude="
				+ logintitude + ", latitude=" + latitude + ", address="
				+ address + ", hypostatic=" + hypostatic + ", deliver="
				+ deliver + ", secondHand=" + secondHand + ", barter=" + barter
				+ ", distance=" + distance + "]";
	}

	
	
}
