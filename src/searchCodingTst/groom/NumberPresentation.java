package searchCodingTst.groom;

public class NumberPresentation {
//출처 : https://level.goorm.io/exam/43129/%EC%88%AB%EC%9E%90-%ED%91%9C%ED%98%84/quiz/1
	
	public static void main(String[] args) throws Exception {
		int input = 5;
		int result = 1;

		result += solution(5);
		
		System.out.print(result);
	}
	
	public static int solution(int inp) {
		
		if(inp ) {
			
		}
		for( int i = inp-1; i > 0; i++) {
			solution(i);
		}
		
		return 1;
	}
}
