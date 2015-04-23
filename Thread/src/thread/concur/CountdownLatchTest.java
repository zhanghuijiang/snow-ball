package thread.concur;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class CountdownLatchTest {

	public static long time(Executor executor,int concurrency,final Runnable action) throws InterruptedException{
		
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ready.countDown();//tell timer we're ready
					try {
						start.await();
						action.run();//wait till peers are ready
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown();//tell timer we're done
					}
				}
			});
		}
		
		ready.await(); //wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown(); //and they're off
		done.await();//wait for all workers to finish
		return System.nanoTime() - startNanos;
	}
	
	
	public static void main(String[] args){
//		time(executor, concurrency, action);
	}
	
}
