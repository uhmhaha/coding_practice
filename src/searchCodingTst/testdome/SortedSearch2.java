package searchCodingTst.testdome;

import java.util.Arrays;

public class SortedSearch2 {
    public static int countNumbers(int[] sortedArray, int lessThan) {
    	
       	int startIdx= 0;
    	int endIdx = sortedArray.length-1;

    	
    	if(sortedArray[startIdx] > lessThan) {
    		return 0;
    	}else if(sortedArray[endIdx] <= lessThan) {
    		return endIdx+1;
    	}
    	//index 쫓아가는게 틀렸다.....ㅠㅠㅠ
    	while(true) {
    		
    		int midIdx = (startIdx + endIdx) / 2;
    		
    		if(lessThan == sortedArray[midIdx] ) {
    			return midIdx+1;
    		}
    		
    		if( lessThan < sortedArray[midIdx]) {
    			endIdx = midIdx -1; 
    		}else if(lessThan > sortedArray[midIdx]) {
    			startIdx = midIdx +1;
    		}
    		//두개가남았다..
    		if(endIdx - midIdx == 1) {
    			if(sortedArray[midIdx] > lessThan) {
					return midIdx;
				}else if(sortedArray[midIdx] == lessThan){
					return midIdx+1;
				}else if(sortedArray[endIdx] <= lessThan){
					return endIdx+1;
				}else if(sortedArray[endIdx] > lessThan){
					return endIdx;
				}
    		}
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch2.countNumbers(new int[] { 2, 3}, 8));
    }
}


//fail 1. array index 가 틀려져버린다.
//public static int countNumbers(int[] sortedArray, int lessThan) {
//	
//	int result = 0;
//	
//	int endIdx = sortedArray.length / 2;
//	if(sortedArray.length == 1) {
//		if(sortedArray[0]..endIdx.
//	}
//	
//	if( lessThan <= sortedArray[endIdx]) {
//		countNumbers( Arrays.copyOfRange(sortedArray,0 ,endIdx-1), lessThan);
//	}else if( sortedArray[endIdx] < lessThan ){
//		countNumbers(Arrays.copyOfRange(sortedArray,endIdx+1 ,sortedArray.length  ) , lessThan);
//	}
//	return result;
//}