package code.thread.observable.test;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import code.thread.observable.Observable;
import code.thread.observable.SetObserver;

/**
 * 死锁测试
 * @author arvin
 */
public class ExecutorTest {

	public static void main(String[] args) {
		
		Observable<Integer> set = new Observable<Integer>(new HashSet<Integer>());
		
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(final Observable<Integer> set, Integer e) {
				System.out.println(e);
				if(e == 23){
					ExecutorService executor = Executors.newSingleThreadExecutor();
					final SetObserver<Integer> observer = this;
					try {
						
						executor.submit(new Runnable(){
							@Override
							public void run() {
								set.removeObserver(observer);
							}
						}).get();
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (ExecutionException e1) {
						e1.printStackTrace();
					} finally{
						executor.shutdown();
					}
				}
			}
		});
		
		for (int i = 0; i < 100; i++) {
			 set.add(i);
		}
	}

}
