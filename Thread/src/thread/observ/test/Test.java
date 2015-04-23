package thread.observ.test;

import java.util.HashSet;

import thread.observ.Observable;
import thread.observ.SetObserver;

/**
 * 异常测试
 * @author arvin
 */
public class Test {

	public static void main(String[] args) {
		
		Observable<Integer> set = new Observable<Integer>(new HashSet<Integer>());
		
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(Observable<Integer> set, Integer e) {
				System.out.println(e);
				if(e == 23){
					//notifyElementAdded 可以防止并发修改，但无法防止迭代线程本身回调到可观察的集合中，也无法防止修改
					set.removeObserver(this);
				}
			}
		});
		
		for (int i = 0; i < 100; i++) {
			 set.add(i);
		}
	}

}
