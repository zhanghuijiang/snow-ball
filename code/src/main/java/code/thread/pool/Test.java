package code.thread.pool;

public class Test {

	public static void main(String[] args) {
        for (int i = 0; i <1; i++) {
			ThreadPool.getInstance().start(new MyThread("testThreadPool"+Integer.toString(i)));
		}
	}
}
