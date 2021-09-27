package searchCodingTst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DoublePriorityQueue {
    public static int[] solution(String[] operations) {
        int[] answer = {};
        MyQueue queue = new MyQueue();
        
        for(String op : operations ) {
        	String[] opersStrings = op.split(" ");
        	
        	if(opersStrings[0].equals("I")) {
        		queue.insert(Integer.parseInt(opersStrings[1]));
        	}else if(opersStrings[0].equals("D")) {
        		if(opersStrings[1].equals("1"))
        			queue.deleteByMax();
        		else if (opersStrings[1].equals("-1"))
        			queue.deleteByMin();
        	}else {
        		return null;
        	}
        	
        }
        if(queue.getQueue().size() == 0 ) {
        	queue.insert(0);
        	queue.insert(0);
        }
        answer = queue.getResult();
        return answer;
    }
    
    public static void main(String[] args) {
    	//int[] result = solution(new String[] {"I 16","D 1"});
    	//"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
    	int[] result =solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    	printArray(result);
    	
    }
    
    
    public static void printArray( int[] arr) {
    	System.out.print("arrays : ");
    	
    	if(arr.length == 0) {
    		System.out.println("[0,0]");
    		return;
    	}
    	
    	System.out.print("[");
    	
    	for(int i = 0; i < arr.length; i++ ) {
    		
    		System.out.print(arr[i]);
    		
    		if( i != arr.length -1) {
    			System.out.print(",");
    		}
    	}
    	System.out.print("]");

    }
}

//operations	return
//["I 16","D 1"]	[0,0]
//["I 7","I 5","I -5","D -1"]	[7,5]
class MyQueue  {
	
	private List<Integer> queue;
	
	public MyQueue() {
		queue = new ArrayList<>();
	}
	public List<Integer> getQueue() {
		return queue;
	}
	public void deleteByMax() {
		if(queue.size() == 0)
			return;
		queue.remove(0);
	}
	public void deleteByMin() {
		if(queue.size() == 0)
			return;
		queue.remove(queue.size()-1);
	}
	public void insert(int e) {
		queue.add(e);
		queue.sort(Comparator.reverseOrder());
	}
	
	public int[] getResult() {
		
		return new int[] {queue.get(0), queue.get(queue.size()-1)};
	}
}
