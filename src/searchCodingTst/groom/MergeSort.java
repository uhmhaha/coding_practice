package searchCodingTst.groom;

public class MergeSort {
	//참고 : https://javaoop.tistory.com/7
	//주석잘나와있음 : https://wonit.tistory.com/201
	public static void main(String[] args) {
		int [] arr = {10, 2, 6, 4, 3, 7, 5};
		
		mergeSort(arr, 0, arr.length-1);
		
		printArray(arr);

	}
	
	public static void mergeSort(int[] arr, int sIdx, int eIdx) {
		int midIdx = -1;
		
		if(sIdx < eIdx) {
 			midIdx = (sIdx + eIdx) /2;
			mergeSort(arr, sIdx, midIdx);
			mergeSort(arr, midIdx+1, eIdx);
			merge(arr, sIdx, midIdx, eIdx);
		}
		
	}
	
	public static void printArray(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
	}
	
	public static void merge(int[] arr, int sIdx, int midIdx, int eIdx) {
		
		int[] result = new int[arr.length];
		int lsIdx = sIdx;
		int rsIdx = midIdx+1;
		int mergeInx = sIdx;
		//int iEIdx = eIdx; 마지막 숫자가 문제네..
		// 일단 재밋는건 stack 이다. 0,1부터해서 4,5까지 순서대로된다. 근데 마지막 숫자는..
		if( rsIdx > arr.length-1) {
			return;
		}
		
		while( lsIdx <= midIdx &&  rsIdx <= eIdx) {
			if(arr[lsIdx] < arr[rsIdx]) {
				result[mergeInx++] = arr[lsIdx++];
			}else {
				result[mergeInx++] = arr[rsIdx++];
			}
		}
		
		while(lsIdx <= midIdx) {
			result[mergeInx++] = arr[lsIdx++];
		}
		
		while(rsIdx <= eIdx) {
			result[mergeInx++] = arr[rsIdx++];
		}
		
		for(int i = sIdx; i <  mergeInx; i++)
			arr[i] = result[i];
	}
}
