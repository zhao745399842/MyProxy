package com.proxy.test;

import com.proxy.cglib.CglibInterceptor;
import com.proxy.cglib.GenerationProxy;
import com.proxy.jdk.PersonProxy;
import com.proxy.myProxy.UserMyProxy;

public class Test {

	public static void main(String[] args){
		System.out.println("********************JDK��̬����********************************************");
		//1.ʹ��jdb��̬����
		PersonProxy p=new PersonProxy(new ZhangSan());
		Person person=(Person) p.getProxyObj();
		person.findLove();
		
		
		System.out.println("*******************�Զ�JDK��̬����*********************************************");
		//2.ʹ���Զ��嶯̬����ģʽ
		UserMyProxy p2=new UserMyProxy(new ZhangSan());
		Person person2=null;
		try {
			person2 = (Person) p2.getProxyObj();
			person2.findLove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("*******************ʹ��CGLIB��̬����*********************************************");
		//3.ʹ��cglib����̬����
		ZhangSan zhangsan=GenerationProxy.getProxyInstance(new CglibInterceptor());
		zhangsan.findLove();
		
	}
	
}
