package com.zycus.utility;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import entries.*;

class Run {

	public static String package1 = "xyz.123";

	public static void main(String[] args) throws IOException {
		String package1 = args[0];
		Runtime runtime = Runtime.getRuntime();
		
		Method name;
		try {
			Class classname=Class.forName(package1);
			Object obj=classname.newInstance();
			name = classname.getMethod("main", new Class[0]);
			name.invoke(obj, (Object[])args);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		runtime.gc();
		long memoryUsed = (runtime.totalMemory() - runtime.freeMemory()) / 1000L;
		System.out.println("Memory Used: " + memoryUsed + " kb");
	}
}