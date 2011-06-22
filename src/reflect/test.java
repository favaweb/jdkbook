package reflect;

import java.lang.reflect.*;

public class test {
	public void t1(){
		
	}
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception{
		Class objClass = Class.forName("reflect.ObjImpl");
		ObjInterface obj = (ObjInterface) (objClass.newInstance());
		Method method = obj.getClass().getMethod("getGreeting", new Class[]{int.class,String.class});
		Object result = method.invoke(obj, new Object[]{1,"s"});
		System.out.println("·µ»Ø½á¹û£º"+(String)result);
	}
}


