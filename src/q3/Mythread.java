package q3;

public class Mythread extends Thread{
	volatile int Thread_num;
	volatile int numTotalInc;
	volatile Counter counter;
	volatile int times;
    // Please create numThread threads to increment the counter
    // Each thread executes numTotalInc/numThread increments
    // Please calculate the total execute time in millisecond and store the
    // result in executeTimeMS
	public Mythread(Counter counter, int Thread_num, int numTotalInc){
		this.counter = counter;
		this.Thread_num = Thread_num;
		this.numTotalInc = numTotalInc;
		this.times= numTotalInc/Thread_num;
	}
	public void run(){
		//System.out.println("times "+times);
		for (int i=0; i< times; i++){
			counter.increment();
			//System.out.println("thread "+Main.mapThread.get(Thread.currentThread())+" running");
		}
	}

}
