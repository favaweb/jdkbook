package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class test {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		String CLASS_NAME="annotation.Myclass";
		Class test = Class.forName(CLASS_NAME);
		boolean flag = test.isAnnotationPresent(ClassAnnotation.class); 
		if (flag) {
			ClassAnnotation classAnnotation = (ClassAnnotation) test.getAnnotation(ClassAnnotation.class);
			System.out.println(classAnnotation.value());
			System.out.println("---------------------------");
		}
		
		Set<Method> set = new HashSet<Method>();
		Method[] methods = test.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(MethodAnnotation.class)) {
				set.add(methods[i]);
			}
		}
		for (Method m : set) {
			MethodAnnotation methodAnnotation = m.getAnnotation(MethodAnnotation.class);
			System.out.println("方法："+methodAnnotation.methodName());
			System.out.println("目的："+methodAnnotation.destination());
		}
		System.out.println("---------------------------");
		
		Set<Field> set2 = new HashSet<Field>();
		Field[] fields = test.getFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(FieldAnnotation.class)) {
				set2.add(fields[i]);
			}
		}
		for (Field f : fields) {
			FieldAnnotation fieldAnnotation =
				f.getAnnotation(FieldAnnotation.class);
			System.out.println("属性的描述："+fieldAnnotation.value());
		}
	}
}
