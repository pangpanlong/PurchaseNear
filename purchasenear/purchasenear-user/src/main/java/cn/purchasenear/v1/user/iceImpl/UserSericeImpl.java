package cn.purchasenear.v1.user.iceImpl;

import Ice.Current;
import cn.purchasenear.v1.user.regist.ActivateInfo;
import cn.purchasenear.v1.user.regist.ClientInfo;
import cn.purchasenear.v1.user.regist._UserServiceDisp;
import cn.purchasenear.v1.user.service.UserService;
/**
 * Ice服务端调用的具体实现  
 * 
 * @author lgshendy
 *
 */
public class UserSericeImpl extends _UserServiceDisp{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795303205200960493L;
	private UserService service  = new UserService();

	@Override
	public ActivateInfo regist(ClientInfo info, Current __current) {
		return service.regist(info);
		
	}

}
