[["java:package:cn.purchasenear.service.buy"]]
module cart {
struct CartInfo{
	long userId;
	string token;
	long goodsId;
	int amount;
};
struct OpCartInfo{
	int status;
};
interface CartService{
	OpCartInfo addCart(CartInfo info);
};
};