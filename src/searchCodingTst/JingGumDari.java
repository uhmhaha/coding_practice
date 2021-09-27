package searchCodingTst;

public class JingGumDari {

	public static void main(String[] args) {
		
		int result = solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3);
		System.out.print("result : "+ result);
		
	}
	
    public static int solution(int[] stones, int k) {
        
    	int answer = 0;
        int nextIdx = 0;
        boolean flag = true;
        
        while( flag ) {
	        for( int currentIdx = 0;currentIdx < stones.length;currentIdx++) {
	        	if( stones[currentIdx] - 1 >= 0) {
	        		stones[currentIdx] = stones[currentIdx] - 1;
	        		nextIdx = 0;
	        	} else {
	        		System.out.print(nextIdx);
	        		nextIdx++;
	        	}
	        	
	        	if( nextIdx == k) {
	        		flag = false;
	        		answer--;
	        		break;
	        	}
	        }
	        printArray(stones);
	        answer++;
	        System.out.println("answer : " + answer);
        }


        return answer;
    }
    
    public static void printArray( int[] arr) {
    	System.out.print("arrays : ");
    	
    	for(int value : arr ) {
    		System.out.print(value + ", ");
    	}
    	System.out.println();
    }
}
