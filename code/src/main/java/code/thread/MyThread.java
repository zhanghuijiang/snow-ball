package code.thread;

public class MyThread implements Runnable {

	protected String name;

	public MyThread() {
	}

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
