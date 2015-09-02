package cn.purchasenear.v1.iceclient;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.purchasenear.v1.user.regist.ActivateInfo;
import cn.purchasenear.v1.user.regist.ClientInfo;
import cn.purchasenear.v1.user.regist.UserServicePrx;
import cn.purchasenear.v1.user.regist.UserServicePrxHelper;

/**
 * 简单的ICE客户端  用于请求注册
 * @author lgshendy
 *
 */
public class SimpleIceUserClient {
	private static final Logger loger = LoggerFactory.getLogger("sys");
	static {
		try {
			PropertyConfigurator.configure("conf/log4j.properties");
		} catch (Exception e) {
			e.printStackTrace();
			Runtime.getRuntime().exit(-1);
		}
	}
	
	
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try{
			//初始化通讯器
			ic = Ice.Util.initialize(args);
			//传入远程服务单元名称、网络协议、Ip以及端口，构造代理对象
			Ice.ObjectPrx base = ic.stringToProxy("UserService:default -p 10000");
			UserServicePrx prxy = UserServicePrxHelper.checkedCast(base);
			if(prxy==null){
				throw new Error("Invalid proxy");
			}
			//调用服务方法
			ClientInfo  info = new ClientInfo();
			info.password="1111";
			info.phone="18000000002";
			info.realname="zhangsan";
			//传入具体的参数
			ActivateInfo ai = prxy.regist(info);
			loger.info("从服务端获取的消息为:::{}",ai.status);
			//根据返回结果进行操作
		}catch(Exception e){
			e.printStackTrace();
			status = 1;
		}finally{
			if(ic != null){
				ic.destroy();
			}
		}
		System.exit(status);
	}
}
