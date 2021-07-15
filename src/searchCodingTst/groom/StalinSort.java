package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StalinSort {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int defaultVal = Integer.MAX_VALUE;

		// 1. 배열의 수를 입력
		int aN = Integer.valueOf(br.readLine());
		int[] numbers = new int[aN];
		// 2. 숫자 입략 
		String[] input = br.readLine().split(" ");
		int i = 0;
		for( String s : input)
			numbers[i++] = Integer.valueOf(s);
		
		//3 최소값구하기 
		
	}
}
