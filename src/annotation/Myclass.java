package annotation;
@ClassAnnotation("Annoation用于类")
public class Myclass {
	@MethodAnnotation(methodName="method1",destination="Annotation用于方法")
	public String method1(){
		return this.id;
	}
	@MethodAnnotation(methodName="method2",destination="Annotation用于方法")
	public String method2(){
		return null;
	}
	@FieldAnnotation("Annotation用于属性")
	public String id="007";
}
