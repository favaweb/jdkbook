package thread;

public class StopThread {
	public static void main(String[] args) throws InterruptedException {
		Mythread1 thread1 = new Mythread1();
		thread1.setDaemon(false);
		thread1.start();
		
		Thread.sleep(1000);
		synchronized (thread1) {
			thread1.interrupt();
		}
	}
}

class Mythread1 extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			try {
				System.out.println("<" + 1 + ">" + "�����С�����");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("�̱߳���ֹ");
				e.printStackTrace();
				break;
			}
		}
		System.out.println("�߳̽���������");
		System.out.println(test());
	}
	
	public int test(){
		try {
			if(true)
			throw new Exception();
			return 1;
		} catch (Exception e) {
			return 2;
		}finally{
			System.out.println("���԰�");
		}
	}
}
