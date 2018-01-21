package com.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibInterceptor implements MethodInterceptor{

	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("CGLIB====>买套西服，理个发，打扮打扮。");
		Object result=methodProxy.invokeSuper(object, objects);
		System.out.println("CGLIB====>来了一个很不靠谱的，太丑了，告吹了。");
		return result;
	}
    

}
