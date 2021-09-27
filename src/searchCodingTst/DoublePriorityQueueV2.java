package searchCodingTst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DoublePriorityQueueV2 {
    public static int[] solution(String[] operations) {
        int[] answer = {};
        int idx = 0;
        for(String op : operations ) {
        	String[] opersStrings = op.split(" ");
        	
        	if(opersStrings[0].equals("I")) {
        		answer[idx] = Integer.parseInt(opersStrings[1]);
        	}else if(opersStrings[0].equals("D")) {
        		if(opersStrings[1].equals("1"))
        			answer[answer.length-1] = null;
        		else if (opersStrings[1].equals("-1"))
        			queue.deleteByMin();
        	}else {
        		return null;
        	}
        	
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] result =solution(new String[] {"I 16","D 1"});
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
		queue.remove(0);
	}
	public void deleteByMin() {
		queue.remove(queue.size()-1);
	}
	public void insert(int e) {
		queue.add(e);
		queue.sort(Comparator.reverseOrder());
	}
}
