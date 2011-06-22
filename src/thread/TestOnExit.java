package thread;
/**
 * �����˳��¼�
 * @author FANY
 *
 */
public class TestOnExit {
	public TestOnExit(){
		doShutDownWork();
	}
	private void doShutDownWork(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				System.out.println("�˳��¼�����Ӧ��");
			}
		});
	}
	public static void main(String[] args) throws InterruptedException {
		TestOnExit testor = new TestOnExit();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			Thread.sleep(1000);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Ӧ�ó����ʱ"+(endTime-beginTime)+"���룡");
	}
}
