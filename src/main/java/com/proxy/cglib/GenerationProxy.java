package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

import com.proxy.test.ZhangSan;

public class GenerationProxy {
	
	public static ZhangSan getProxyInstance(CglibInterceptor myProxy) {
        Enhancer enhancer = new Enhancer();
        // ��Enhancer�е�superclass���Ը�ֵ��BookServiceBean
        enhancer.setSuperclass(ZhangSan.class);
        // ��Enhancer�е�callbacks���Ը�ֵ��myProxy
        enhancer.setCallback(myProxy);
        return (ZhangSan) enhancer.create();
    }
}
