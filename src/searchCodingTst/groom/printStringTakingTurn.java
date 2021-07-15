package searchCodingTst.groom;

import java.io.*;
public class printStringTakingTurn {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);
		
		int std = 0;
		int endIdx = input.length()-1;
		int mul = -1;
		StringBuilder result = new StringBuilder("");
		result.append(input.substring(std, 1));
		
		for(int i = endIdx; i > 0; i--) {
			mul = mul * -1;
			std = std + i*mul;
			result.append(input.substring(std, std+1));
		}
		System.out.println("your result is : " + result);
		
	}
}
