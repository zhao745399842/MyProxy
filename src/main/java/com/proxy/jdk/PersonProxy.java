package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 演示jdk动态代理
 * @author Administrator
 *
 */
public class PersonProxy implements InvocationHandler{
    
	private Object obj;
	public PersonProxy(Object target){
		this.obj=target;
	}
	
	public  Object getProxyObj(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.obj.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("买套西服，理个发，打扮打扮。");
		method.invoke(obj, args);
		System.out.println("来了一个很不靠谱的，太丑了，告吹了。");
		return null;
	}

}
