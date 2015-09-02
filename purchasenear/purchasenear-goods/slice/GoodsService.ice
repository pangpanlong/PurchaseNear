[["java:package:cn.purchasenear.v1.goods.rpcservice.ice.interf"]]
module goods {
struct SearchInfo{
	long userId;
	string token;
	double longitude;
	double latitude;
	double distance;
	int page;
	int pageSize;
	string goodsName;
	string sellerName;
	string goodsCategory;
	string brand;
	double lowPrice;
	double highPrice;
	int hypostatic;
	int deliver;
	int secondHand;
	int barter;
	bool price;
	bool saled;
	bool browsed;
	bool sellerCredit;

};

struct GoodsInfo{
	long goodsId;
	string goodsName;
	string sellerName;
	long category;
	int band;
	int stock;
	double price;
	double logintitude;
	double latitude;
	string address;
	int hypostatic;
	int deliver;
	int secondHand;
	int barter;
	double distance;

};
sequence<GoodsInfo> goodsInfoList;

struct SearchGoods{
	int status;
	int page;
	goodsInfoList goodsList;
	long goodsId;
	string goodsName;
	long category;
	int stock;
	double logintitude;
	double latitude;
	string address;
	int  hypostatic;
	int deliver;
	int  secondHand;
	int  barter;
	double distance;
};

interface GoodsSearchService{
	SearchGoods search(SearchInfo info);
};
};