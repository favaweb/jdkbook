package thread;

public class NotifyWaitingThread {
	public static void main(String[] args) throws InterruptedException {
		mythread();
		runnable();
	}

	private static void mythread() throws InterruptedException {
		MyThread[] threads = new MyThread[3];
		for(int i=0;i<3;i++){
			threads[i] = new MyThread();
			threads[i].no = i;
			//threads[i].setPriority(i);
			threads[i].setDaemon(true);
			threads[i].start();
		}
		Thread.sleep(500);
		for(int i=0;i<3;i++){
			synchronized (threads[i]) {
				threads[i].notify();
			}
		}
	}
	private static void runnable() throws InterruptedException{
		Runner[] runners = new Runner[3];
		Thread[] threads = new Thread[3];
		for(int i=0;i<3;i++){
			runners[i] = new Runner(i);
			threads[i] = new Thread(runners[i]);
			//threads[i].setPriority(i);
			threads[i].setDaemon(true);
			threads[i].start();
		}
		Thread.sleep(500);
		for(int i=0;i<3;i++){
			synchronized (runners[i]) {
				runners[i].notify();
			}
		}
	}
}
