package searchCodingTst;

public class Grading {
    public static int solution(int n, int[][] results) {
    	
        int answer = 0;
        int[][] calResult = new int[][] {};
        
        System.out.print(results.length);
        System.out.print(results[0].length);
        
        //
        for(int i = 0; i < results.length ; i++ ) {
        	for(int j = 0; j < results[i].length; j++) {
        		//두숫자를비교를 해서 큰 숫자와 작은 숫자를 나눈다.
        		//
        	}
        }
        
        
        return answer;
    }
    
    public static void main( String[] args) {
    	
    	int num = solution(5, new int[][] { {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    	//System.out.print(num);
    }
}
