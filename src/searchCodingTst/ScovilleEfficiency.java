package searchCodingTst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScovilleEfficiency {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        //convert to int[] to arraylist
        List<Integer> scovilleArr = new ArrayList<Integer>(scoville.length);
        for (int i : scoville)
        {
        	scovilleArr.add(i);
        }
        
        Collections.sort(scovilleArr);
        
        //Arrays.copyOf(original, newLength);
        boolean isOver = true;
        
        while(isOver) {
        	// K 보다 작고 array가 1개남앗으면 return -1
        	if(scovilleArr.size() < 2 && scovilleArr.get(0) < K) {
        		answer = -1;
        		break;
        	}
        	//둘다 K보다 낮으면, 로직 계산 수행하고 array에서 하나를 제거 
        	if(scovilleArr.get(0) < K) {
        		scovilleArr.set(1, scovilleArr.get(0) + (scovilleArr.get(1) * 2));
        		scovilleArr.remove(0);
        		answer +=1;
        	} else {
        		isOver = false;
        	}
        	
        	Collections.sort(scovilleArr);
        }
        	
        
        return answer;
    }
    
    public static void main( String[] args) {
    	int num = solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
    	System.out.print(num);
    	
    }
}
