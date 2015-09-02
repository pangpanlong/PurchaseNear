[["java:package:cn.purchasenear.service.reset"]]
module Reset {
struct ResetInfo{
	 long orderId;
     long flashSalesId;
};

interface ResetService{
	ResetInfo flashsales(long orderId,long flashSalesId);
};
};