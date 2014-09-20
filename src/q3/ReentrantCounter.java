package q3;

import java.util.concurrent.locks.ReentrantLock;

// TODO
// Use ReentrantLock to protect the count
public class ReentrantCounter extends Counter {
    @Override
    public void increment() {
    	ReentrantLock lock = new ReentrantLock();
    	lock.lock();
    	count++;
    	lock.unlock();
    }

    @Override 
    public int getCount() {
        return count;
    }
}
