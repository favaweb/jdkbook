package thread;

public class MyThread extends Thread {
	public int no = 0;
	public void run(){
		System.out.println("��"+this.no+"���߳̿�ʼ�ȴ�����ӡ�");
		try {
			synchronized (this) {
				this.wait(5*60*1000);
			}
		} catch (Exception e) {
			System.out.println("�̱߳���ֹ");
			e.printStackTrace();
		}
		System.out.println("��"+this.no+"���̱߳����ѡ�");
	}
}
