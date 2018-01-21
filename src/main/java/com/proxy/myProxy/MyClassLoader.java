package com.proxy.myProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream in=null;
		ByteArrayOutputStream out = null;
		String path=this.getClass().getResource("").getPath();
		String calssName=MyClassLoader.class.getPackage().getName()+"."+name;
		File f=new File(path,name+".class");
		try {
			in=new FileInputStream(f);
			out=new ByteArrayOutputStream();
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))!=-1){
				out.write(b,0,len);
			}
			return this.defineClass(calssName, out.toByteArray(), 0, out.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
