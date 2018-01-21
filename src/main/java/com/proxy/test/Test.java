package com.proxy.test;

import com.proxy.cglib.CglibInterceptor;
import com.proxy.cglib.GenerationProxy;
import com.proxy.jdk.PersonProxy;
import com.proxy.myProxy.UserMyProxy;

public class Test {

	public static void main(String[] args){
		System.out.println("********************JDK动态代理********************************************");
		//1.使用jdb动态代理
		PersonProxy p=new PersonProxy(new ZhangSan());
		Person person=(Person) p.getProxyObj();
		person.findLove();
		
		
		System.out.println("*******************自定JDK动态代理*********************************************");
		//2.使用自定义动态代理模式
		UserMyProxy p2=new UserMyProxy(new ZhangSan());
		Person person2=null;
		try {
			person2 = (Person) p2.getProxyObj();
			person2.findLove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("*******************使用CGLIB动态代理*********************************************");
		//3.使用cglib做动态代理
		ZhangSan zhangsan=GenerationProxy.getProxyInstance(new CglibInterceptor());
		zhangsan.findLove();
		
	}
	
}
