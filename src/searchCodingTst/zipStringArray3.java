package searchCodingTst;

public class zipStringArray3 {

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
		//len이 1이면 1을 return
		if(inputLen == 1)
			return 1;
		
		for (int windowSize = 1; windowSize <= inputLen / 2; windowSize++) {
			//string count는 windowStr이 교체될때 0으로 재세팅 
			strCount = 0;
			//input 문자열중 window size 만큼을 이동해 가면서 비교할 예정 
			windowStr = s.substring(0, windowSize);
			result = "";
			int j = 0;
			
			// string이 다른데
			// 남은 length가 window보다 작다면 남은 string을 이어붙이고 교할필요가없다.
			// windowStr 교체  count 붙이거
			// windowStr 교체  count 안붙이거나 
			for (j = 0; j + windowSize <= inputLen; j += windowSize) {
				System.out.println("j : "+j+" , windowSize : " + windowSize + " , windowSize + j : "+ Integer.sum(windowSize, j));
				
				//windowString이 문자가 같으면 계속해서 count를 증가시킴  
				if (windowStr.equals(s.substring(j, j + windowSize))) {
					strCount += 1;
				}
				//기준string(windowString)을 교체하는 경우는
				//카운트를 붙이고 기준 string을 교체한다.
				//다르면 concat을 수행하고 windowstr을 교체한다.
				else {
					//concat을 수행
					if (strCount > 1) {
						result = result.concat(Integer.toString(strCount));
					}
					result = result.concat(windowStr);
					//windowstr을 교체 
					windowStr = s.substring(j, j+windowSize );
					strCount = 1;

				}	
				System.out.println("j : "+j+" , windowSize : " + windowSize + " , windowSize + j : "+ Integer.sum(windowSize, j));
			}
			// 마지막roof는 누구도 비교하지않는다.
			// 마지막까지 비교하지 않고 skip하는 경우는 남은 stirng이 짧을때는 그냥 붙인다
			if (j < inputLen) {
				if (strCount > 1) {
					result = result.concat(Integer.toString(strCount));
				}
				result = result.concat(windowStr);
				result = result.concat(s.substring(j, inputLen ));
				//result = result.concat(windowStr);
				
			}
			else if (j == inputLen) {
				if (strCount > 1) {
					result = result.concat(Integer.toString(strCount));
				}
				result = result.concat(windowStr);
			}
			else if (j > inputLen) {
				result = result.concat(windowStr);
			}
			
			if (answer == 0 || answer > result.length()) {
				System.out.println("result : " + result);
				answer = result.length();
			}
		}
		System.out.println(result + ": , length : " + answer);
		return answer;
	}

	public static void main(String[] args) {
		int number = solution("abcabcdede");
		System.out.print(number);
	}
}
