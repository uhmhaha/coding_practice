package searchCodingTst;

public class zipStringArray2 {

	public static int solution(String s) {
		
		String result = "";
		//정답 
		int answer = 0;
		//입력값길
		int inputLen = s.length();
		//각 기준문자열, 문자열이 바뀌면 교체함  
		String windowStr = "";	
		//기준문자열과 같은 문자의 개수, prefix + 문자...
		int strCount = 0;
		if(inputLen == 1)
			return 1;
		for (int windowSize = 1; windowSize <= inputLen / 2; windowSize++) {
			//string count는 windowStr이 교체될때 0으로 재세팅 
			strCount = 0;
			//input 문자열중 window size 만큼을 이동해 가면서 비교할 예정 
			windowStr = s.substring(0, windowSize);
			result = "";
			for (int j = 0; j < inputLen; j += windowSize) {

				//windowString이 같으면count 증가
				
				// string이 같으면 count만 증가
				
				if (j+windowSize <= inputLen && windowStr.equals(s.substring(j, j + windowSize))) {
					strCount += 1;
	
				// string이 다른데
				// 남은 length가 window보다 작다면 남은 string을 이어붙이고 교할필요가없다.
				// windowStr 교체  count 붙이거
				// windowStr 교체  count 안붙이거나 
				}else{
					if (strCount > 1) {
						result = result.concat(Integer.toString(strCount));
						
					}
					result = result.concat(windowStr);
					
//					//마지막 round의 경우이며 글자수가 적게남은 경
					if( j+windowSize <= inputLen) {
						windowStr = s.substring(j, j+windowSize );
						strCount = 1;
					//마지막 round의 경우이며 글자수가 적게남은 경우는 for문을 나갈예정이므로 마지막 string 과count를 붙임 
					}else {
						if (strCount > 1) {
							result = result.concat(Integer.toString(strCount));
						}
						result = result.concat(s.substring(j, inputLen ));
					}

				}
				
				if(inputLen == j+windowSize) {
					//마지막 count에 붙이기 
					if(strCount > 1) {
						result = result.concat(Integer.toString(strCount));
					}
					result = result.concat(windowStr);		
				}
			}

			if (answer == 0 || answer > result.length()) {
				answer = result.length();
			}
		}
		//System.out.print(result);
		return answer;
	}

	public static void main(String[] args) {
		int number = solution("ababcdcdababcdcd");
		System.out.print(number);
	}
}
