package thread;

public class Runner implements Runnable {
	private int no = 0;

	
	public Runner(int no) {
		this.no = no;
	}


	public void run() {
		System.out.println("��"+this.no+"���߳̿�ʼ�ȴ�����ӡ�");
		try {
			synchronized (this) {
				this.wait(5*60*1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��"+this.no+"���̱߳����ѡ�");
	}
}
