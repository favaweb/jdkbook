package annotation;
@ClassAnnotation("Annoation������")
public class Myclass {
	@MethodAnnotation(methodName="method1",destination="Annotation���ڷ���")
	public String method1(){
		return this.id;
	}
	@MethodAnnotation(methodName="method2",destination="Annotation���ڷ���")
	public String method2(){
		return null;
	}
	@FieldAnnotation("Annotation��������")
	public String id="007";
}
