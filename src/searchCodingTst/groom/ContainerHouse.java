package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//testcase 3 fail. 일단, 음수 배열을 별도로 두고 해보자.
public class ContainerHouse {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int inputLen = Integer.parseInt(br.readLine());
//		
//		int[] arr = new int[inputLen];
//		
//		for( int i = 0; i < arr.length-1; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		int[] result = selectionSort(arr);
//		System.out.println(getMaxFloor(result));
		
		int[] arr = { 8, 11, -9, -3, 2, 5, 18, 17, -15, 4 };

		int[] result = selectionSort(arr);

		printArray(result);

		System.out.println(getMaxFloor(result));
		
	}

	public static int getMaxFloor(int[] arr) {
		int lIdx = 0;
		int rIdx = arr.length - 1;
		// all is minus or plus return 1
		if (arr[rIdx] < 0 || arr[lIdx] > 0)
			return 1;
		int result1 = fromLIdxcalculate(arr);
		int result2 = fromRIdxCalculate(arr);
		
		return result1 > result2 ? result1 : result2;
		//return result2;
	}

	public static int fromLIdxcalculate(int[] arr) {

		int lIdx = 0;
		int rIdx = arr.length - 1;
		int result = 1;

		// 0->(+18)->18->(-17)->1->(16)->17...
		for (int j = 0; j < arr.length - 1; j++) {

			if (j % 2 == 0) {
				while(arr[rIdx] > 0 && lIdx < rIdx){
					if (arr[lIdx] * (-1) > arr[rIdx]) {
						result++;
						lIdx++;
						break;
					}else {
						rIdx--;
					}
				}
			} else {
				while(arr[lIdx] < 0 && lIdx < rIdx){
					if (arr[lIdx] * (-1) < arr[rIdx]) {
						result++;
						rIdx--;
						break;
					}else {
						lIdx++;
					}
				}
			}
		}

		return result;
	}

	public static int fromRIdxCalculate(int[] arr) {
		int lIdx = 0;
		int rIdx = arr.length - 1;
		int result = 1;

		// 0->(+18)->18->(-17)->1->(16)->17...
		for (int j = 0; j < arr.length - 1; j++) {

			if (j % 2 != 0) {
				while(arr[rIdx] > 0 && lIdx < rIdx){
					if (arr[lIdx] * (-1) > arr[rIdx]) {
						result++;
						lIdx++;
						break;
					}else {
						rIdx--;
					}
				}
			} else {
				while(arr[lIdx] < 0 && lIdx < rIdx){
					if (arr[lIdx] * (-1) < arr[rIdx]) {
						result++;
						rIdx--;
						break;
					}else {
						lIdx++;
					}
				}
			}
		}

		return result;
	}

	public static int[] selectionSort(int[] arr) {

		// 1. 최소값탐색범위 &swap
		for (int j = 0; j < arr.length; j++) {
			int min_val = Integer.MAX_VALUE;
			int min_idx = -1;
			int temp = -1;

			for (int i = j; i < arr.length; i++) {
				if (min_val > arr[i]) {
					min_val = arr[i];
					min_idx = i;
				}
			}

			// 2. swap value
			temp = arr[j];
			arr[j] = min_val;
			arr[min_idx] = temp;

		}

		return arr;

	}

	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
	}
}

//public static int getMaxFloor(int[] arr) {
//	int floor = 0;
//	int startIdx = -1;
//	int endIdx = -1;
//	int shiftSatrtValue = -1;
//	int mul = -1;
//	//all is minus or plus return 1
//	if( arr[arr.length-1] < 0 || arr[0] > 0)
//		return 1;
//	
//	//which is greater?
//	if( arr[0] * (-1) < arr[arr.length-1]) {
//		startIdx = arr.length-1;
//		endIdx = 0;
//		shiftSatrtValue = (arr.length-1) * (-1);
//		mul = -1;
//		
//		// 18->(-18)->0->(17)->17->(-16)->1->(15)->16...
//		for( int i = 0; i < arr.length; i++) {
//			
//			//ready for nex roof
//			mul = mul * -1;
//			shiftSatrtValue = (shiftSatrtValue * mul) * mul;
//		}
//	}else {
//		startIdx = 0;
//		endIdx = arr.length-1;
//		shiftSatrtValue = arr.length-1;
//		mul = -1;
//		// 0->(+18)->18->(-17)->1->(16)->17...
//		for(int j = 0; j < arr.length; j++) {
//
//			//ready for nex roof
//			mul = mul * -1;
//			shiftSatrtValue = (shiftSatrtValue * mul) * mul;
//			
//			if(arr[shiftSatrtValue] )
//		}
//	}
//	
//	return floor;
//}
