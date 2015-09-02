package org.purchasenear.common.ice.server;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

import Ice.Communicator;
import Ice.Identity;
import IceBox.Service;

public abstract class AbstractIceBoxService implements Service {
	protected Ice.ObjectAdapter _adapter;
	protected Identity id;
	protected static org.slf4j.Logger logger = LoggerFactory
			.getLogger(AbstractIceBoxService.class);
	protected static Sl4jLogerI iceLogger=new Sl4jLogerI("communicator");

	
	/**
	 * start方法：
		创建服务的Adapter，
		然后创建Object对象，通过抽象方法 createMyIceServiceObj创建。
		
		然后通过PerfDispatchInterceptor类的addICEObject方法，对Object进行封装，获取一个DispatchInterceptor对象，做为Sevant对象。

	 */
	@Override
	public void start(String name, Communicator communicator, String[] args) {
		Ice.Util.setProcessLogger(iceLogger);
		// 创建objectAdapter，这里和service同名
		_adapter = communicator.createObjectAdapter(name);
		// 创建servant并激活
		Ice.Object object = this.createMyIceServiceObj(args);
		id = communicator.stringToIdentity(name);
		// _adapter.add(object, communicator.stringToIdentity(name));
		_adapter.add(PerfDispatchInterceptor.addICEObject(id, object), id);
		_adapter.activate();
		logger.info(name + "service started ,with param size " + args.length
				+ " detail:" + Arrays.toString(args));
	}

	/**
	 * 创建具体的ICE 服务实例对象
	 * 
	 * @param args
	 *            服务的配置参数，来自icegrid.xml文件
	 * @return Ice.Object
	 */
	public abstract Ice.Object createMyIceServiceObj(String[] args);

	@Override
	public void stop() {
		logger.info("stopping service " + id + " ....");
		_adapter.destroy();
		PerfDispatchInterceptor.removeICEObject(id);
		logger.info("stopped service " + id + " stoped");

	}

}
