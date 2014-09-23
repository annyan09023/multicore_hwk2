package q3;

import java.util.concurrent.locks.ReentrantLock;

// TODO
// Use ReentrantLock to protect the count
public class ReentrantCounter extends Counter {
    
    private ReentrantLock lock = new ReentrantLock();
    @Override 
    public void increment() {
    	lock.lock();
    	count++;
    	lock.unlock();
    }

    @Override 
    public int getCount() {
    	lock.lock();
        int this_count=count;
        lock.unlock();
        return this_count;
    }
}
