package cn.purchasenear.v1.goods.domain;

import java.io.Serializable;

import cn.purchasenear.v1.goods.rpcservice.ice.interf.goods.SearchInfo;

@SuppressWarnings("serial")
public class SearchInfoVO implements Serializable,Cloneable {

	private long userId; // 登录的用户ID
	private String token; // 登录的token
	private double longitude; // 用户经度，必须与纬度一起出现
	private double latitude; // 用户纬度，必须与经度一起出现
	private double distance; // 查询距离用户distance米半径的商品
	private int page; // 查询当前页数
	private int pageSize; // 查询每页商品数
	private String goodsName; // 商品名，模糊查询
	private String sellerName; // 卖家名，模糊查询
	private String goodsCategory; // 商品类别id,
								// goods_category.id，事先由接口3.5得到卖家名、商品名、商品类别三个条件必须至少有一个
	private String brand; // 按品牌查询
	private double lowPrice; // 查询的商品价格不低于此值
	private double highPrice; // 查询的商品价格不高于此值
	private int hypostatic = 0; // 是否有实体店，-1：只查询没有实体店的，0：忽略本参数，1：只查询有实体店的。
	private int deliver = 0; // 是否送货上门，-1：只检索不送货上门的，0：忽略此参数，1：只检索送货上门的
	private int second_hand = 0; // 是否二手，-1：只检索非二手货，0：忽略此参数，1：只检索二手货
	private int barter = 0; // 是否以物易物，-1：只检索不可以物易物的，0：忽略此参数，1：只检索可以物易物的
	private boolean price; // 是否以商品价格排序，默认false
	private boolean saled; // 是否以销量排序，默认false
	private boolean browsed; // 是否以浏览量排序，默认false
	private boolean seller_credit; // 是否以卖家信誉排序，默认false，暂不实现。user_info.credit
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
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
	public int getSecond_hand() {
		return second_hand;
	}
	public void setSecond_hand(int second_hand) {
		this.second_hand = second_hand;
	}
	public int getBarter() {
		return barter;
	}
	public void setBarter(int barter) {
		this.barter = barter;
	}
	public boolean isPrice() {
		return price;
	}
	public void setPrice(boolean price) {
		this.price = price;
	}
	public boolean isSaled() {
		return saled;
	}
	public void setSaled(boolean saled) {
		this.saled = saled;
	}
	public boolean isBrowsed() {
		return browsed;
	}
	public void setBrowsed(boolean browsed) {
		this.browsed = browsed;
	}
	public boolean isSeller_credit() {
		return seller_credit;
	}
	public void setSeller_credit(boolean seller_credit) {
		this.seller_credit = seller_credit;
	}
	
	
	@Override
	public String toString() {
		return "SearchInfo [userId=" + userId + ", token=" + token
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", distance=" + distance + ", page=" + page + ", pageSize="
				+ pageSize + ", goodsName=" + goodsName + ", sellerName="
				+ sellerName + ", goodsCategory=" + goodsCategory + ", brand="
				+ brand + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice
				+ ", hypostatic=" + hypostatic + ", deliver=" + deliver
				+ ", second_hand=" + second_hand + ", barter=" + barter
				+ ", price=" + price + ", saled=" + saled + ", browsed="
				+ browsed + ", seller_credit=" + seller_credit + "]";
	}
	
    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

	public void copy(SearchInfo info){
		setUserId(info.userId);
		setToken(info.token);
		setLongitude(info.longitude);
		setLatitude(info.latitude);
		setDistance(info.distance);
		setPage(info.page);
		setPageSize(info.pageSize);
		setGoodsName(info.goodsName);
		setSellerName(info.sellerName);
		setGoodsCategory(info.goodsCategory);
		setBrand(info.brand);
		setLowPrice(info.lowPrice);
		setHighPrice(info.highPrice);
		setHypostatic(info.hypostatic);
		setDeliver(info.deliver);
		setSecond_hand(info.secondHand);
		setBarter(info.barter);
		setPrice(info.price);
		setSaled(info.saled);
		setBrowsed(info.browsed);
		setSeller_credit(info.sellerCredit);
	}
	
	public void to(SearchInfo info){
		info.userId=getUserId();
		info.token=getToken();
		info.longitude=getLongitude();
		info.latitude=getLatitude();
		info.distance=getDistance();
		info.page=getPage();
		info.pageSize=getPageSize();
		info.goodsName=getGoodsName();
		info.sellerName=getSellerName();
		info.goodsCategory=getGoodsCategory();
		info.brand=getBrand();
		info.lowPrice=getLowPrice();
		info.highPrice=getHighPrice();
		info.hypostatic=getHypostatic();
		info.deliver=getDeliver();
		info.secondHand=getSecond_hand();
		info.barter=getBarter();
		info.price=isPrice();
		info.saled=isSaled();
		info.browsed=isBrowsed();
		info.sellerCredit=isSeller_credit();

	}
	
	
}
