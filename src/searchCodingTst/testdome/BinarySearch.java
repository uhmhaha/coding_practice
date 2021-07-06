package searchCodingTst.testdome;

public class BinarySearch {
	
	public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        binarySearch(2, arr);

	}
	
	public static void binarySearch(int num, int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		int mid = arr.length / 2;;
		
		while(start < end) {
			
			System.out.println("mid is : "+ mid + " start : " + start + " end" + end);
			mid = start + end / 2;
			
			
			if( num == arr[mid]) {
				System.out.println("index is : "+ mid + "num : " + num);
				break;
			}
			
			if( num > arr[mid]) {
				start = mid + 1 ;
			}else {
				end = mid -1 ;
			}
			
		}
	}
}
