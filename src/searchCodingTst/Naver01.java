package searchCodingTst;

import java.util.*;

public class Naver01 {

	public static int solution(String S) {
		// write your code in Java SE 8
		String[] temp = new String[3];
		int count = 0;
		int partOfA = 0;
		int aPartEndIndexes[] = {0,0,0};
		int idx = 0;
		
		int answer = 1;
		//a가 공평하도록 나눈다. 마지막이 a 가 되도
		for (int i = 0; i < S.length(); i++) {
		    if (S.charAt(i) == 'a') {
		        count++;
		    }
		}

		//3의 배수가 아니면 0을 리턴 
		if( count % 3 != 0) {
			return 0;
		}else {
			partOfA = count / 3;
		}
		
		int aCount = 0;
		//3 부분으로 나누기 위한 a의 end index를 구한다.
		for(int j = 0; j < S.length(); j++) {
			
			if(S.charAt(j) == 'a') {
				aCount++;
				if(aCount == partOfA ) {
					aPartEndIndexes[idx++] = j;
					aCount = 0;
				}
			}

		}
		//a를 세부분으로 나눈다.
		temp[0] = S.substring(0, aPartEndIndexes[0]+1 );
		temp[1] = S.substring(aPartEndIndexes[0]+1, aPartEndIndexes[1]+1);
		temp[2] = S.substring(aPartEndIndexes[1]+1, S.length());
		
		//temp[1] count
		for( int k = 0; k < temp[1].length(); k++) {
			if( temp[1].charAt(k) != 'a') {
				answer++;
				for( int t = 0; t < temp[2].length(); t++) {
					if( temp[2].charAt(t) != 'a')
						answer++;
				}
			}
			else
				break;
		}
		
//		//temp[2] count
//		for( int t = 0; t < temp[2].length(); t++) {
//			if( temp[2].charAt(t) != 'a')
//				answer++;
//			else
//				break;
//		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.print(solution("babaa"));
		System.out.print(solution("ababa"));

	}
}
