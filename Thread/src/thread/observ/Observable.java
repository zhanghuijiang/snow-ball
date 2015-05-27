package thread.observ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 观察者模式
 * 该类允许客户端在将元素添加到集合中时预定通知
 * @author arvin
 * @param <E>
 */
public class Observable<E> extends ForwardingSet<E> {

	public Observable(Set<E> s) {
		super(s);
	}

	//观察者集合
	private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();
	
	//添加观察者
	public void addObserver(SetObserver<E> observer){
		synchronized (observers) {
			observers.add(observer);
		}
	}

	//移除观察者
	public boolean removeObserver(SetObserver<E> observer){
		synchronized (observers) {
		   return observers.remove(observer);	
		}
	}
	
	//添加通知
    private void notifyElementAdded(E element){
    	//将外来方法移出同步代码快
    	List<SetObserver<E>> snapshot = null;
    	synchronized (observers) {
    		snapshot  = new ArrayList<SetObserver<E>>(observers);
		}
    	for (SetObserver<E> observer : snapshot) {
			observer.added(this, element);
		}
    }
	
    
    //重新集合的添加方法
    @Override
    public boolean add(E element){
    	boolean added = super.add(element);
    	if(added){
    		notifyElementAdded(element);
    	}
    	return added;
    }
    
    @Override
	public boolean addAll(Collection<? extends E> c){
		boolean result = false;
		for (E element : c) {
			result = add(element);
		}
		return result;
	}
	
}
