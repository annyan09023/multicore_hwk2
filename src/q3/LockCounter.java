package q3;
// TODO
// Use MyLock to protect the count

public class LockCounter extends Counter {
	MyLock this_lock;
    public LockCounter(MyLock lock) {
    	count=0;
    	this_lock = lock;
    }

    @Override
    public void increment() {
    	int myId;
    	myId=Main.mapThread.get(Thread.currentThread());
    	this_lock.lock(myId);
    	count++;
    	this_lock.unlock(myId);
    }

    @Override
    public int getCount() {
        return count;
    }
}
