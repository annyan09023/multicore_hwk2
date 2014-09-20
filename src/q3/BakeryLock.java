package q3;

// TODO
// Implement the bakery algorithm

public class BakeryLock implements MyLock {
	private volatile boolean[]flag;
	private volatile int[] label;
	private int Thread_num;
    public BakeryLock(int numThread) {
    	this.Thread_num = numThread;
    	this.flag = new boolean[numThread];
    	this.label = new int[numThread];
    	for (int i =0 ; i< numThread; i++){
    		this.flag[i]=false;
    		this.label[i]=0;
    	}
    }
    @Override
    public void lock(int myId) {
    	flag[myId]=true;
    	int max=label[0];
    	for (int i=0; i<Thread_num; i++){
    		if (label[i]>max)
    			max=label[i];
    	}
    	label[myId]=max+1;
    	//System.out.println("label:"+label[myId]+" id:"+myId);
    	boolean op_flag=true;
    	while (op_flag==true){
    		op_flag=false;
    		for (int i=0; i<Thread_num; i++){
    			if(i!=myId){
    				if (label[i]<label[myId]&&flag[i]==true)
    					op_flag=true;
    				else if(label[i]==label[myId]&&i<myId&&flag[i]==true)
    					op_flag=true;
    			}
    		}
    	}
    	return;
    }

    @Override
    public void unlock(int myId) {
    	flag[myId]=false;
    }
}
