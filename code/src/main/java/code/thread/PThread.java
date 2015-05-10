package code.thread;

public class PThread extends Thread {

	private ThreadPool pool;

	private Runnable target;

	private boolean isShoutDown = false;

	private boolean isIdle = false;

	public PThread(Runnable target, String name, ThreadPool pool) {
		super(name);
		this.pool = pool;
		this.target = target;
	}

	public Runnable getTarget() {
		return target;
	}

	public boolean isIdle() {
		return isIdle;
	}

	@Override
	public void run() {
		while (!isShoutDown) {
			isIdle = false;
			if (target != null) {
				target.run();
			}
			isIdle = true;
			try {
				pool.repool(this);
				synchronized (this) {
					wait();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			isIdle = false;
		}
	}

	public synchronized void setTarget(Runnable newTarget) {
		target = newTarget;
		notifyAll();
	}

	public synchronized void showDown() {
             isShoutDown = true;
             notifyAll();
	}

}
