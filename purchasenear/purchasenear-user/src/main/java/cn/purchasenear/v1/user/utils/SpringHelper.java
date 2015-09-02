package cn.purchasenear.v1.user.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringHelper implements ApplicationContextAware {
	
	 private static ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext  applicationContext)
			throws BeansException {
		 appContext = applicationContext;
		
	}
	
	 public static Object getBean(String paramString) {
	    return appContext.getBean(paramString);
	  }
}
