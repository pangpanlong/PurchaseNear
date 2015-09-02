[["java:package:cn.purchasenear.v1.user"]]
module regist {
struct ClientInfo{
	string mac;
	string imei;	
	string openUdid;
	string idfa;
	int os;
	string osVersion;
	string manufacture;
	long platformCode;
	string signature;
	string packageName;
	string phone;
	string verifyCode;
	string password;
	string realname;
};
struct ActivateInfo{
	int status;
};
interface UserService{
	ActivateInfo regist(ClientInfo info);
};
};