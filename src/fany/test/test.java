package fany.test;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//many("i");
		many("i","love","u");

	}
	
	public static void many(String...strings){
		for(String one: strings){
			System.out.println(one);
		}
	}
}
