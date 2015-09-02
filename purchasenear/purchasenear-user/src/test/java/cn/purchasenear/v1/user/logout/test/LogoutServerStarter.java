package cn.purchasenear.v1.user.logout.test;

import cn.purchasenear.v1.user.logout.impl.UserServiceI;

public class LogoutServerStarter {
	public static void main(String[] args) {
		int status = 0;
		try {
			Ice.Communicator communicator = Ice.Util.initialize(args);
			Ice.ObjectAdapter adapter = communicator
					.createObjectAdapterWithEndpoints("LogoutAdapter",
							"default -h localhost -p 10000");
			adapter.add(new UserServiceI(),
					communicator.stringToIdentity("logout"));
			adapter.activate();
			communicator.waitForShutdown();
			communicator.destroy();
		} catch (Ice.LocalException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		System.exit(status);
	}
}
