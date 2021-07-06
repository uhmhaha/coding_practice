package searchCodingTst;

import java.util.*;

public class MissingInteger {
	
    public static int solution(int[] A) {
        // write your code in Java SE 8
    	int answer = 0;
    	int calVal = 0;
    	
    	Arrays.sort(A);
    	
    	for( int i = 0; i < A.length; i++)
    		if( A[i] == calVal+1) {
    			calVal = A[i];
    			if(i == A.length-1) {
        			answer = A[i]+1;
        		}
    		}else if(A[i] > answer+1){
    			answer = calVal + 1; 
    			break;
    		}
    	if(answer == 0) answer = 1;
    		
		return answer;
    }
    
    public static void main(String[] args) {
    	System.out.print(solution(new int[] {1, 3, 6, 4, 1, 2}))	;
    	System.out.print(solution(new int[] {1, 2, 3}))	;
    	System.out.print(solution(new int[] {-1,-3}))	;
    }
}
