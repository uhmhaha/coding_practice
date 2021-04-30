package searchCodingTst;

import java.util.Arrays;

public class Scoville {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        //int[] calArr = new int[scoville.length];
        Arrays.sort(scoville);
        
        //Arrays.copyOf(original, newLength);
        boolean isOver = true;
        
        while(isOver) {
        	// K 보다 작고 array가 1개남앗으면 return -1
        	if(scoville.length < 2 && scoville[0] < K) {
        		answer = -1;
        		break;
        	}
        	//둘다 K보다 낮으면, 로직 계산 수행하고 array에서 하나를 제거 
        	if(scoville[0] < K) {
        		scoville[1] = scoville[0] + (scoville[1] * 2);
        		scoville[0] = 0;
        		scoville = Arrays.copyOfRange(scoville, 1,scoville.length);
        		answer +=1;
        	} else {
        		isOver = false;
        	}
        	
        	Arrays.sort(scoville);
        }
        	
        
        return answer;
    }
    
    public static void main( String[] args) {
    	int num = solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
    	System.out.print(num);
    	
    }
}
