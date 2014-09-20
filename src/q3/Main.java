package q3;

import java.util.HashMap;

public class Main {
	public static HashMap<Thread, Integer> mapThread = new HashMap<Thread, Integer>();
	public static Thread [] thread_sets;
    public static void main (String[] args) {
        Counter counter = null;
        MyLock lock;
        long executeTimeMS = 0;
        int numThread = 6;
        int numTotalInc = 1200000;

        if (args.length < 3) {
            System.err.println("Provide 3 arguments");
            System.err.println("\t(1) <algorithm>: fast/bakery/synchronized/"
                    + "reentrant");
            System.err.println("\t(2) <numThread>: the number of test thread");
            System.err.println("\t(3) <numTotalInc>: the total number of "
                    + "increment operations performed");
            System.exit(-1);
        }
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        if (args[0].equals("fast")) {
            lock = new FastMutexLock(numThread);
            counter = new LockCounter(lock);
        } else if (args[0].equals("bakery")) {
            lock = new BakeryLock(numThread);
            counter = new LockCounter(lock);
        } else if (args[0].equals("synchronized")) {
            counter = new SynchronizedCounter();
        } else if (args[0].equals("reentrant")) {
            counter = new ReentrantCounter();
        } else {
            System.err.println("ERROR: no such algorithm implemented");
            System.exit(-1);
        }
        
        numThread = Integer.parseInt(args[1]);
        numTotalInc = Integer.parseInt(args[2]);
        
        // TODO
        // Please create numThread threads to increment the counter
        // Each thread executes numTotalInc/numThread increments
        // Please calculate the total execute time in millisecond and store the
        // result in executeTimeMS
       
        thread_sets = new Mythread[numThread];
        for (int i=0; i<numThread; i++){
        	thread_sets[i] = new Mythread(counter, numThread, numTotalInc);
        	mapThread.put(thread_sets[i], i);
        	thread_sets[i].start();
        }
        while (counter.getCount()<numTotalInc){
        	//System.out.println("haha"+counter.getCount());
        	executeTimeMS++;}
        System.out.println(counter.getCount());
        System.out.println(executeTimeMS);
    }
}
