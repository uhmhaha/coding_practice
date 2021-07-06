package searchCodingTst;

public class Counters {
	public static int[] solution(int N, int[] A) {
		
		int[] answer = new int[N];
		int[] midsum = new int[N];
		int tempVal = 0;
		int currentMaxVal = 0;
		int tempIndex = -1;
		
		for( int i = 0; i < A.length; i++) {
			if( A[i] <= N && 1 <= A[i]) {
				answer[A[i]-1]++;
				if(answer[A[i]-1] > currentMaxVal) {
					tempVal = answer[A[i]-1];
					tempIndex = A[i]-1;
				}
				System.out.println("A[" + i+"]:"+A[i] +" - add index : i :"+(A[i]-1)+" value :" + answer[A[i]-1]);
			}else if( A[i] == N+1) {
				//answer[tempIndex] -= tempVal;
				answer = midsum;
				currentMaxVal += tempVal;
				System.out.println("currentMaxVal : "+currentMaxVal);
			}
		}
		
		if(currentMaxVal != 0 )
			for( int j = 0; j < answer.length; j++) {
					answer[j] += currentMaxVal;
				    System.out.println("answer[j]: "+answer[j] +" currentMaxVal " + currentMaxVal);
			}
		
		return answer;

	}

	public static void main(String[] args) {
		
		for( int total :solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }))
		System.out.println("total:"+total);
	}
}
