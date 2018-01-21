package com.proxy.myProxy;

import java.lang.reflect.Method;

import com.proxy.test.Person;

public class UserMyProxy implements MyInvocationHandler{
    private Person zhangsan;
    
    public UserMyProxy(Person zhangsan){
    	this.zhangsan=zhangsan;
    }
    
    public Object getProxyObj () throws Exception {
    	return MyProxy.newProxyInstance(new MyClassLoader(), zhangsan.getClass().getInterfaces()[0], this);
    }
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("自己的代理=====买套西服，理个发，打扮打扮。");
		method.invoke(zhangsan, args);
		System.out.println("自己的代理=====来了一个很不靠谱的，太丑了，告吹了。");
		
		return null;
	}
	

}
