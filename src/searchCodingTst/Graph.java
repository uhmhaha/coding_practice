package searchCodingTst;

import java.util.Arrays;

public class Graph {

	//1. 배열에 결과저장
	//2. 추가로 경로가 잇는지를 확인하여 저장( i -> k -> j = i가 j에 승리함 )
	//3. b , a = a,b 를 알면 순위가 정해짐 
    public static int solution(int n, int[][] results) {
    	//https://in-intuition.tistory.com/25 참고 
    	//https://iamheesoo.github.io/blog/algo-prog49191 참고2
        int answer = 0;
       
   	 	boolean[][] calcResult = new boolean[n][n];
   	 	
   	 	//1. 배열에 결과저장 
   	 	for( int i= 0; i < results.length; i++) {
   	 		calcResult[results[i][0]-1][results[i][1]-1] = true;
   	 	}
   	 	//2. 배열에 추가 결과저장 ( i -> k -> j = i가 j에 승리함 )
   	 	for( int i = 0; i < calcResult.length; i++) {
	   	 	for( int j = 0; j < calcResult.length; j++) {
	   	 		for( int k = 0; k < calcResult.length;k++) {
	   	 			if( calcResult[j][i] && calcResult[i][k])
	   	 				calcResult[j][k] =  true;
	   	 		}
	   	 	}
   	 	}
   	 	//3.a,b or b,a가 true 결과가 잇으면 answer++ n-1개 만큼결과가 잇어야
   	 	for( int i= 0; i < n; i++) {
   	 		int resultOfEachNode = 0;
   	 		for( int j= 0; j < n; j++) {
   	 			if(calcResult[i][j] || calcResult[j][i] ) {
   	 				resultOfEachNode++;
   	 			}
   	 		}
   	 		if( resultOfEachNode == n-1) {
   	 			answer++;
   	 		}
   	 		resultOfEachNode = 0;
   	 	}
   	 	
		return answer;
    }
    
    public static void main(String[] args) {
    	
    	int num = solution(5, new int[][] { {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    	System.out.print(num);
    }
}
