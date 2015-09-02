package cn.purchasenear.v1.user.logout.impl;



import org.apache.log4j.Logger;
import Ice.Current;
import cn.purchasenear.v1.jedis.JedisUtil;
import cn.purchasenear.v1.user.logout._UserServiceDisp;


public class UserServiceI extends _UserServiceDisp{
	
	final static Logger logger =  Logger.getLogger(UserServiceI.class);
	
	public int logout(long userid, String token, Current __current) {
		
		logger.info("user logout param: userId "+userid+" : token "+token);
		
		int status = 1;
		try{
			JedisUtil jedis = JedisUtil.getInstance();
			jedis.del("userSession:"+userid);
			
		}catch(Exception e){
			status = 0;
			logger.error(e.getMessage()+":"+e.getCause());
		}
		
		logger.info("user logout return status : "+status);
		
		return status;
	}

}
