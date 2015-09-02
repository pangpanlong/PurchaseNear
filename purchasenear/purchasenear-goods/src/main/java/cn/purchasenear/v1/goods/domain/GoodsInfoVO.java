package cn.purchasenear.v1.goods.domain;

import java.io.Serializable;

import org.elasticsearch.search.SearchHit;

import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.GoodsInfo;

@SuppressWarnings("serial")
public class GoodsInfoVO implements Serializable,Cloneable{

	private long goodsId;

	private String goodsName;
	
	private String sellerName;

	private long category;

	private double price;
	
	private int stock;

	private int brand;
	
	private double logintitude;

	private double latitude;

	private String address;

	private int hypostatic;

	private int deliver;

	private int secondHand;

	private int barter;

	private double distance;


	
	
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
	
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "GoodsInfoVO [goodsId=" + goodsId + ", goodsName=" + goodsName +", sellerName" + sellerName
				+ ", category=" + category + ", stock=" + stock + ", price=" + price + ", brand=" + brand
				+ ", logintitude=" + logintitude + ", latitude=" + latitude
				+ ", address=" + address + ", hypostatic=" + hypostatic
				+ ", deliver=" + deliver + ", secondHand=" + secondHand
				+ ", barter=" + barter + ", distance=" + distance + "]";
	}
	
	public void copy(SearchHit hit){
		
		
		setGoodsId((int) hit.getSource().get("goodsId"));
        setGoodsName((String) hit.getSource().get("goodsName"));
        setCategory((int) hit.getSource().get("goodsCategory"));
        setStock((int) hit.getSource().get("stock"));
        setPrice(Float.parseFloat(""+hit.getSource().get("price")));
        setBrand((int) hit.getSource().get("brandId"));
        setSecondHand((int) hit.getSource().get("secondHand"));
        setBarter((int) hit.getSource().get("barter"));
        java.util.ArrayList locations =  (java.util.ArrayList) hit.getSource().get("locations");
        setLatitude(Double.parseDouble(locations.get(0)+""));
        setLogintitude(Double.parseDouble(locations.get(1)+""));
        //更新时间先不做处理
	}
	
	public void to(GoodsInfo info) {
		info.goodsId = goodsId;
		info.goodsName = goodsName;
		info.sellerName= sellerName;
		info.category= category;
		info.price= price;
		info.stock= stock;
		info.band = brand;
		info.logintitude= logintitude;
		info.latitude= latitude;
		info.address= address;
		info.hypostatic= hypostatic;
		info.deliver= deliver;
		info.secondHand= secondHand;
		info.barter = barter;
	}
	
	@Override
	public java.lang.Object clone() {
		java.lang.Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException ex) {
			assert false; // impossible
		}
		return o;
	}

	public void from(GoodsInfo info) {
		setGoodsId(info.goodsId );
		setGoodsName(info.goodsName );
		setSellerName(info.sellerName);
		setCategory(info.category);
		setPrice(info.price);
		setStock(info.stock);
		setBrand(info.band );
		setLogintitude(info.logintitude);
		setLatitude(info.latitude);
		setAddress(info.address);
		setHypostatic(info.hypostatic);
		setDeliver(info.deliver);
		setSecondHand(info.secondHand);
		setBarter(info.barter );

		
	}

}
