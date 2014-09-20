package q3;

// TODO 
// Use synchronized to protect count
public class SynchronizedCounter extends Counter {
    @Override
    public synchronized void increment() {
    	count++;
    }

    @Override 
    public int getCount() {
        return count;
    }
}
