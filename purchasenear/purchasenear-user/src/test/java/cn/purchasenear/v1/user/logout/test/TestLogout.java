package cn.purchasenear.v1.user.logout.test;

import cn.purchasenear.v1.user.logout.UserServicePrx;
import cn.purchasenear.v1.user.logout.UserServicePrxHelper;
import junit.framework.TestCase;

public class TestLogout extends TestCase {

	public void testLogout() {
		String[] args = {};
        Ice.Communicator communicator = Ice.Util.initialize(args);
        UserServicePrx prx = UserServicePrxHelper.checkedCast(communicator.stringToProxy("logout:default -h localhost -p 10000"));
		int status = prx.logout(1111, "aaa");
		 communicator.destroy();
		assertEquals(1, status);
	}

}
