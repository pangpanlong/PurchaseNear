package cn.purchasenear.v1.iceserver;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.purchasenear.v1.user.iceImpl.UserSericeImpl;

/**
 * 这里是一个简短的ICE服务端   该服务端对外提供user处理
 *  不使用ICEbox进行多任务管理
 * @author lgshendy
 *
 */
public class SimpleIceUserServer {
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
		loger.info("userService starting");
		SimpleIceUserServer server = new SimpleIceUserServer();
		final FileSystemXmlApplicationContext cx = new FileSystemXmlApplicationContext("classpath*:spring-config.xml");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				cx.close();
			}
		});
		server.startIceServer(args);
		loger.info("userService started");
	}
	private  void startIceServer(String[] args){
		int status = 0;
		Ice.Communicator ic = null;
		try{
			//初始化Communicator对象，args可以传入初始化参数 如连接超时，初始化客户端连接池的数量等
			ic = Ice.Util.initialize(args);
			//创建名为UserServcieAdapter的objectAdapter，使用缺省通信协议（tcp/Ip 端口为10000的请求）
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("UserServcieAdapter",
						"default -p 10000");
			//实例化一个服务对象
			UserSericeImpl service = new UserSericeImpl();
			//将service 加入到ObjectAdapter中，并将service关联到Id为UserService的Ice object
			adapter.add(service, Ice.Util.stringToIdentity("UserService"));
			//激活
			adapter.activate();
			System.out.println(" userService started");
			//让服务在推出之前一致持续对请求的监听
			ic.waitForShutdown();
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
