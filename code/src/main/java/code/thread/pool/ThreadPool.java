package code.thread.pool;

import java.util.List;
import java.util.Vector;

public class ThreadPool {

	private static ThreadPool instance = null;
	// 空闲的线程队列
	private List<PThread> idleThreads;
	// 已有的线程数量
	private int threadCounter;

	private boolean isShutDown = false;

	private ThreadPool() {
		this.idleThreads = new Vector(5);
		this.threadCounter = 0;
	}

	public int getCreatedThreadsCount() {
		return threadCounter;
	}

	// 获取线程池的实例
	public synchronized static ThreadPool getInstance() {
		if (instance == null) {
			instance = new ThreadPool();
		}
		return instance;
	}

	// 将线程放入池中
	protected synchronized void repool(PThread repoolingThread) {
		if (!isShutDown) {
			idleThreads.add(repoolingThread);
		} else {
			repoolingThread.showDown();
		}
	}

	// 停止池中的所有线程
	public synchronized void shutdown() {
         isShutDown = true;
         for (int i = 0; i < idleThreads.size(); i++) {
			PThread idleThread = idleThreads.get(i);
			idleThread.showDown();
		}
	}

	// 执行任务
	public synchronized void start(Runnable target) {
       PThread thread = null;
       if(idleThreads.size() > 0){
    	   int lastIndex = idleThreads.size() -1;
    	   thread = idleThreads.get(lastIndex);
    	   idleThreads.remove(lastIndex);
    	   thread.setTarget(target);
       }else{
    	   thread = new PThread(target, "PThread #"+threadCounter, this);
    	   thread.start();
       }
	}
}
