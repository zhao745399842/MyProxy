package com.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibInterceptor implements MethodInterceptor{

	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("CGLIB====>���������������������硣");
		Object result=methodProxy.invokeSuper(object, objects);
		System.out.println("CGLIB====>����һ���ܲ����׵ģ�̫���ˣ��洵�ˡ�");
		return result;
	}
    

}
