[["java:package:cn.purchasenear.service.buy"]]
module Order {
struct flashsales OrderInfo{
	 long id;
	 string ordercode;
     long userid;
     long goodsid;
     int amount;
	 string address;
	 string receivername;
	 string receiverphone;
	 string receiveremail;
	 int orderstatus;
};

struct OpOrderInfo{
	int status;
	long orderId;
};
interface OrderService{
	OrderInfo selCardInfo(long userid,string token);
	OpOrderInfo addOrder(OrderInfo info);
};
};