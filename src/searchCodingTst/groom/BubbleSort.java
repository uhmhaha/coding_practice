package searchCodingTst.groom;

public class BubbleSort {
	public static void main(String[] args) {
		int [] arr = {10, 2, 6, 4, 3, 7, 5};
		
		
		int[] result = bubbleSort(arr);
		
		printArray(result);

	}
	
	public static int[] bubbleSort(int[] arr) {

		int temp = -1;
		
		for( int i = 0; i < arr.length-1; i++) {
			for( int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
		
	}
	
	public static void printArray(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
	}
}
