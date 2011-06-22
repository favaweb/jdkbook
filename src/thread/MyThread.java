package thread;

public class MyThread extends Thread {
	public int no = 0;
	public void run(){
		System.out.println("第"+this.no+"个线程开始等待五分钟。");
		try {
			synchronized (this) {
				this.wait(5*60*1000);
			}
		} catch (Exception e) {
			System.out.println("线程被终止");
			e.printStackTrace();
		}
		System.out.println("第"+this.no+"个线程被唤醒。");
	}
}
