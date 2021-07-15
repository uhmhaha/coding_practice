package searchCodingTst.groom;

public class InsertionSort {
	public static void main(String[] args) {
		int [] arr = {10, 2, 6, 4, 3, 7, 5};
		
		
		int[] result = insertSort(arr);
		
		printArray(result);

	}
	
	public static int[] insertSort(int[] arr) {

		int temp = -1;
		//1.2부터 시작할 예정  
		for( int i = 1; i < arr.length; i++) {
			for(int j =0; j < i-1; j++) {
				if( arr[i] < arr[j]) {
					//swap()
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] =  temp;
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
