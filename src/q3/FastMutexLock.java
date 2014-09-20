package q3;

// TODO 
// Implement Fast Mutex Algorithm
public class FastMutexLock implements MyLock {
	private volatile int open_id; //-1 refers door open
	private boolean flag[];
	private volatile int last;
	private int Thread_num;
    public FastMutexLock(int numThread) {
    	this.flag=new boolean[numThread];
    	this.Thread_num=numThread;
    	this.open_id=-1;
    	this.last=-1;
    	for(int i =0; i<numThread; i++)
    		this.flag[i]=false;
    }
    @Override
    public void lock(int myId) {
    	while(true){
    		flag[myId]=true;
    		last=myId;
    		if (open_id!=-1){ //door close
    			flag[myId]=false;
    			while (open_id!=-1);
    			continue;
    		}
    		else{
    			open_id=myId; //I close the door
    			if(last==myId)
    				return; //Down
    			else{
    				flag[myId]=false;
    				boolean op_flag=true;
    				while(op_flag==true){
    					op_flag=false;
    					for (int i=0; i<Thread_num; i++){
    						if(flag[i]==true)
    							op_flag=true;
    					}
    				}
    				if(open_id==myId)
    					return;
    				else{
    					while(open_id!=-1);
    					continue;
    				}
    			}
    		}
    	}
    }

    @Override
    public void unlock(int myId) {
    	open_id =-1;
    	flag[myId]=false;
    }
}
