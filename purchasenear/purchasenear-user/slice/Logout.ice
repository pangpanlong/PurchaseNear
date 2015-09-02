[["java:package:cn.purchasenear.v1.user"]]
module logout{
	interface UserService{
    	idempotent int logout(long userid,string token);
	};
};
