package searchCodingTst.groom;

public class SelectionSort {
	public static void main(String[] args) {
		int [] arr = {10, 2, 6, 4, 3, 7, 5};
		
		
		int[] result = selectionSort(arr);
		
		printArray(result);

	}
	
	public static int[] selectionSort(int[] arr) {

		//1. 최소값탐색범위 &swap 
		for( int j = 0; j < arr.length; j++) {
			int min_val = Integer.MAX_VALUE;
			int min_idx = -1;
			int temp = -1;
			
			for( int i = j; i < arr.length; i++) {
				if( min_val > arr[i] ) {
					min_val = arr[i];
					min_idx = i;
				}
			}
			
			//2. swap value
			temp = arr[j];
			arr[j] = min_val;
			arr[min_idx] = temp;
			
		}
		
		
		return arr;
		
	}
	
	public static void printArray(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
	}
}
