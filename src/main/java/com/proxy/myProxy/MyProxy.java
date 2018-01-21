package com.proxy.myProxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String ln="\r\n";
	public static Object newProxyInstance(MyClassLoader loader,Class<?> interfaces,MyInvocationHandler h) throws Exception{
		String proxyClassName="$Proxy12";
		//1.通过反射生成代理对象的java源代码
		StringBuffer javaSrc=new StringBuffer();
		javaSrc.append(" package com.proxy.myProxy;"+ln);
		javaSrc.append(" import java.io.Serializable;  "+ln);
		javaSrc.append(" import java.lang.reflect.Method;  "+ln);
		
		javaSrc.append("   "+ln);
		javaSrc.append("   public class "+proxyClassName+" implements Serializable,"+interfaces.getName()+"{"+ln);
		javaSrc.append("      private "+h.getClass().getName()+" h; "+ln);
		javaSrc.append("      public "+proxyClassName+"("+h.getClass().getName()+" h){"+ln);
		javaSrc.append("          this.h=h;"+ln);
		javaSrc.append("      }"+ln);
		Method[] ms=interfaces.getMethods();
		for(Method m:ms){
			javaSrc.append("   public void findLove() {"+ln);
			javaSrc.append("       try{ "+ln);
			javaSrc.append("       Method m1="+interfaces.getName()+".class.getMethod(\""+m.getName()+"\");"+ln);
			javaSrc.append("       h.invoke(this, m1,null);"+ln);
			javaSrc.append("       }catch(Exception e1){}catch(Throwable e2){} "+ln);
			javaSrc.append("   }"+ln);
		}
		javaSrc.append("   "+ln);
		javaSrc.append("}"+ln);
		
		String path=MyProxy.class.getResource("").getPath();
		File f=new File(path+proxyClassName+".java");
		FileOutputStream outFile=new FileOutputStream(f);
		outFile.write(javaSrc.toString().getBytes());
		//2.编译源代码
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager=compiler.getStandardFileManager(null, null, null);
		
		Iterable<? extends JavaFileObject> compilationUnits1 =fileManager.getJavaFileObjectsFromFiles(Arrays.asList(f));
	    compiler.getTask(null, fileManager, null, null, null, compilationUnits1).call();
	    fileManager.close();
	    
		//3.将编译后的class文件加载到jvm中
		Class proxyClass=loader.findClass(proxyClassName);
		//4.从jvm中返回代理对象
		return proxyClass.getConstructor(h.getClass()).newInstance(h);
	}
}
