package searchCodingTst;

import java.util.Arrays;

public class DistinctArraySort {

    public static int solution(int[] A) {
        // write your code in Java SE 8
    	int answer = 1;
    	
    	//sort
    	Arrays.sort(A);
    	
    	//xor
    	for( int i = 0; i < A.length - 1; i++) {
    		if( 0 != (A[i] ^ A[i+1])) answer++;
    	}
    	
    	return answer;
    	
    }
    
    public static void main(String[] args) {
    	System.out.print(solution(new int[] {2, 1, 1, 2, 3, 1}))	;
    }
}
