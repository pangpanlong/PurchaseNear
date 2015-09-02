package cn.purchasenear.v1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.purchasenear.v1.user.regist.ActivateInfo;
import cn.purchasenear.v1.user.regist.ClientInfo;
import cn.purchasenear.v1.user.service.UserService;

/**
 * 前端通过springMVC访问的控制器
 * @author lgshendy
 *
 */
@Controller
public class RegistControler {
	private UserService userService;
	
	@RequestMapping(value="/user/regist",method=RequestMethod.POST)
	public ActivateInfo register(ClientInfo info){
		userService.regist(info);
		return null;
		
	}
}
