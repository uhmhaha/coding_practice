package searchCodingTst.groom;

public class InsertionSortFinal {
	public static void main(String[] args) {
		int [] arr = {10, 2, 6, 4, 3, 7, 5};
		
		
		int[] result = insertSort(arr);
		
		printArray(result);

	}
	
	public static int[] insertSort(int[] arr) {

		//1.2부터 시작할 예정  
		for( int i = 1; i < arr.length; i++) {
			int standard = arr[i];
			
			for(int j =i-1; -1 < j ; j--) {
				if( standard < arr[j]) {
					//swap()
					arr[j+1] = arr[j];
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
