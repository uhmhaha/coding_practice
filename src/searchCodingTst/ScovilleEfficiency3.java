package searchCodingTst;

import java.util.PriorityQueue;

public class ScovilleEfficiency3 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for( int num : scoville) {
        	p.add(num);
        }
   
        boolean isOver = true;
        
        while(isOver) {
        	// K 보다 작고 array가 1개남앗으면 return -1
        	if(p.size() < 2 && p.peek() < K) {
        		answer = -1;
        		break;
        	}
        	//둘다 K보다 낮으면, 로직 계산 수행하고 array에서 하나를 제거 
        	if(p.peek() < K) {

        		p.add( p.poll() + (p.poll() * 2));
        		
        		answer +=1;
        	} else {
        		isOver = false;
        	}

        }
        	
        
        return answer;
    }
    
    public static void main( String[] args) {
    	int num = solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
    	System.out.print(num);
    	
    }
}
