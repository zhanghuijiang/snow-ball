package thread.observ;

public interface SetObserver<E> {
  void added(Observable<E> set,E element); 
}
