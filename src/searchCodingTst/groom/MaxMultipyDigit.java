package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxMultipyDigit {
	   public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();
	        if(input.length() == 1 ) {
	        	System.out.print(input);
	        	return;
	        }
	        int result[] = new int[4];
	        int maxVal = 0;
	        Arrays.fill(result, 1);
	        //4876
	        int top = Integer.parseInt(input.substring(0, 1));
	        int secTop = Integer.parseInt(input.substring(1, 2));
	        if( input.length() > 2) {
	        	int thirTop = Integer.parseInt(input.substring(2, 3));
		        //앞자기놔두고 다음자리하나빼고 나머지 9
		        result[3] = result[3] * top  * (secTop) * (thirTop-1); 
		        for(int i = 0; i < input.length()-3 ; i++ )
		            result[3] = result[3] * 9 ;
	   		}
	        
	        //그대로 곱하기
	        for(int i = 0; i < input.length() ; i++ )
	        	result[0] = result[0] * Integer.parseInt(input.substring(i, i+1));
	        //앞자리 하나빼고 9채우기 
	        if(top-1 !=0) {
	        	result[1] = result[1] * (top - 1);
	        }
	        for(int i = 0; i < input.length()-1 ; i++ )
	            result[1] = result[1] * 9 ;
	        //앞자기놔두고 다음자리하나빼고 나머지 9
	        result[2] = result[2] * top  * (secTop-1); 
	        for(int i = 0; i < input.length()-2 ; i++ )
	            result[2] = result[2] * 9 ;
	        for( int k = 0; k < result.length; k++) {
	        	if(result[k] > maxVal )
	        		maxVal = result[k];
	        }
	        System.out.print(maxVal);
	        
	    }
}
