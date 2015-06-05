package code.thread.observable;

/**
 * 添加观察者接口
 * @author arvin
 * @param <E>
 */
public interface SetObserver<E> {
  void added(Observable<E> set,E element); 
}
