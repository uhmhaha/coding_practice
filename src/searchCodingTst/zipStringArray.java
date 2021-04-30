package searchCodingTst;

public class zipStringArray {

	public static int solution(String s) {
		int answer = 0;
		int len = s.length();
		String subs = "";
		String result = "";
		int strCount = 0;

		for (int windowSize = 1; windowSize <= len / 2; windowSize++) {

			subs = s.substring(0, windowSize);
			strCount = 0;
			result = "";
			int j = 0;
			//
			for (j = 0; j < len; j += windowSize) {
				// string이 같으면 count만 증가
				if (subs.equals(s.substring(j, j + windowSize))) {
					strCount += 1;

				} else {
					if (strCount > 1) {
						result = result.concat(Integer.toString(strCount));
						result = result.concat(subs);
					} else {
						result = result.concat(subs);
					}
					// string이 다르면 교체
					subs = s.substring(j, j + windowSize);
					strCount = 0;
				}

				if (len <= j + windowSize) {
					if (strCount > 1) {
						result = result.concat(Integer.toString(strCount));
						result = result.concat(subs);
					} else {
						result = result.concat(subs);
					}
				}

			}

			if (answer == 0 || answer > result.length()) {
				answer = result.length();
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int number = solution("aabbaccc");
		System.out.print(number);
	}
}
