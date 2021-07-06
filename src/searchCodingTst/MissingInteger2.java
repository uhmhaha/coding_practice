package searchCodingTst;

import java.util.*;

public class MissingInteger2 {

	public static int solution(int[] A) {
		// write your code in Java SE 8
		// write your code in Java SE 8
		boolean[] checker = new boolean[A.length + 1];
		int checkCount = 0;
		int num;
		for (int i = 0; i < A.length; i++) {
			num = A[i];
			if (num > 0 && num < checker.length)
				checker[num] = true; // 양수 일 때만 체크
		}

		for (int i = 1; i < checker.length; i++) {
			if (checker[i])
				checkCount++;
			else
				return i;
		}

		return checkCount == (checker.length - 1) ? checker.length : 1; // 모두 만족하면 그 다음수 리턴 아니면 모두 음수이므로 양의 최소값 1 리턴
	}

	public static void main(String[] args) {
		System.out.print(solution(new int[] { 1, 10900 }));
//		System.out.print(solution(new int[] { 1, 2, 3 }));
//		System.out.print(solution(new int[] { -1, -3 }));
	}
}
