package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = "X";
		//1. input array size
		String input = br.readLine();
		int[] valArray = new int[Integer.valueOf(input)];
		int idx = 0;
		//2. input array values
		String values = br.readLine();
		String[] tempArray = values.split(" ");
		for(String s: tempArray) {
			valArray[idx++] = Integer.valueOf(s);
		}
		//3. input find values
		int findValue = Integer.valueOf(br.readLine());
		
		int startIdx = 0;
		int endIdx = valArray.length-1;
		int midInx = -1;
		
		while(startIdx <= endIdx) {
			midInx =  (startIdx + endIdx) / 2;
				
			if(valArray[midInx] == findValue) {
				result = String.valueOf(midInx+1);
				break;
			}
			
			if(valArray[midInx] > findValue) {
				endIdx = midInx -1;
			}
			
			if(valArray[midInx] < findValue) {
				startIdx = midInx +1;
			}
		}
		
		System.out.print(result);
		
	}
}
