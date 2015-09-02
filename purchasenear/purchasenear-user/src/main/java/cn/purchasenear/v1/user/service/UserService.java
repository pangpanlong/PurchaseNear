package cn.purchasenear.v1.user.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.purchasenear.v1.user.dao.UserInfoDao;
import cn.purchasenear.v1.user.domain.UserInfo;
import cn.purchasenear.v1.user.regist.ActivateInfo;
import cn.purchasenear.v1.user.regist.ClientInfo;
import cn.purchasenear.v1.user.utils.SpringHelper;

import com.alibaba.fastjson.JSONObject;

/**
 *service 层处理具体的业务逻辑
 * @author lgshendy
 *
 */
public class UserService {
	private static final Logger loger = LoggerFactory.getLogger("sys");
	private UserInfoDao userInfoDao;
	public ActivateInfo regist(ClientInfo info){
		long current = System.currentTimeMillis();
		int status =1;
		try{
			UserInfo userInfo = new UserInfo();
			userInfo.setPassword(info.password);
			userInfo.setReal_name(info.realname);
			userInfo.setPhone(info.phone);
			userInfo.setCredit(1000);
			userInfo.setRegist_time(new Date());
			userInfoDao= (UserInfoDao) SpringHelper.getBean("UserInfoDao");
			userInfoDao.saveUserInfo(userInfo);
			
		}catch(Exception e){
			status = 0;
			loger.debug("插入数据库失败,详细信息为::{}",e.toString());
		}
		ActivateInfo ai = new ActivateInfo();
		ai.status=status;
		long consumed = System.currentTimeMillis()-current;
		JSONObject json = new JSONObject();
		json.put("result", status);
		json.put("params", JSONObject.toJSON(info));
		json.put("consumed", consumed);
		//写入mQ
		loger.info("处理客户端请求完毕，详细信息为:::{}",json.toJSONString());
		return ai;
		
	}
}
