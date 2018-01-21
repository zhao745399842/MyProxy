package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

import com.proxy.test.ZhangSan;

public class GenerationProxy {
	
	public static ZhangSan getProxyInstance(CglibInterceptor myProxy) {
        Enhancer enhancer = new Enhancer();
        // 将Enhancer中的superclass属性赋值成BookServiceBean
        enhancer.setSuperclass(ZhangSan.class);
        // 将Enhancer中的callbacks属性赋值成myProxy
        enhancer.setCallback(myProxy);
        return (ZhangSan) enhancer.create();
    }
}
