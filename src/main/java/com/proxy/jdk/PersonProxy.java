package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * ��ʾjdk��̬����
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
		System.out.println("���������������������硣");
		method.invoke(obj, args);
		System.out.println("����һ���ܲ����׵ģ�̫���ˣ��洵�ˡ�");
		return null;
	}

}
