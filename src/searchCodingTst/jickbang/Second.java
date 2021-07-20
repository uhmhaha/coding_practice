package searchCodingTst.jickbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
public class Second {
	/**
	 * solution 정렬후 큰수부터 뽑아서 뽑은 번째 수를 곱한다.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cardNum = br.readLine().charAt(0) - '0';
		
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[cardNum];
		for(int i = 0; i < input.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		Integer[] integerArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		//numbers to integer
		Arrays.sort(integerArray, Collections.reverseOrder());
		System.out.println(calMaxval(integerArray));
		
	}
	
	public static int calMaxval(Integer[] integerArray) {
		int lIdx = 0;
		int rIdx = integerArray.length-1;
		int multiVal = integerArray.length;
		int idx = integerArray.length;
		
		int result = 0;
		
		while( lIdx <= rIdx) {
			//배열개수가 홀수일경우 
			if(multiVal % 2 == 1) {
				if(idx % 2 == 1) //홀수인경우 
					result += integerArray[lIdx++] * (idx--);
				else
					result += integerArray[rIdx--] * (idx--) * (-1);
			}else
			{//배열개수가 짝수일경우 
				if(idx % 2 == 0) //홀수인경우 
					result += integerArray[rIdx--] * (idx--) * (-1);
				else
					result += integerArray[lIdx++] * (idx--);
			}
			
		}
		return result;
	}
}
