package searchCodingTst.basicjava;

//https://wikidocs.net/103249 코
public class DivideAndConquer {
	public static void main(String[] args) {
		int[] arr = { 8, 5, 3, 2, 7, 1, 9, 10, 4, 6 };
		int size = arr.length;
		
		printArrayOneline(arr);
		quickSort(arr, 0, size - 1);

		printArray(arr);
	}

	public static void quickSort(int[] arr, int sIdx, int eIdx) {

		int lpt = sIdx;
		int rpt = eIdx;
		if(lpt > rpt) return;
		System.out.println("lpt, rpt :" + lpt +" "+rpt);
		int pivotIdx = partionSort(arr, lpt, rpt);
		System.out.println("lpivotIdx :"+ pivotIdx);
		quickSort(arr, lpt, pivotIdx-1);
		quickSort(arr, pivotIdx+1, rpt);

	}

	public static int partionSort(int[] arr, int sIdx, int eIdx) {

		int pivotIdx = sIdx;
		int s = sIdx+1;
		int e = eIdx;
		
		while(s < e) {
			while(arr[s] < arr[pivotIdx]) {s++;}
			while(arr[e] > arr[pivotIdx]) {e--;}
			if(arr[s] > arr[e]&& s < e) {
				swap(arr, s, e);
				System.out.println("in swap :" +s +" "+e);
				printArrayOneline(arr);
			}
		}
		if(s == e && arr[s] < arr[pivotIdx]) {
			swap(arr, s, pivotIdx);
		}
		swap(arr, s-1, pivotIdx);
		System.out.println("final swap :" + (s-1) +" "+pivotIdx);
		printArrayOneline(arr);
		return s-1;
	}

	public static void swap(int[] arr, int sIdx, int eIdx) {
		int temp = arr[eIdx];
		arr[eIdx] = arr[sIdx];
		arr[sIdx] = temp;
	}

	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
	}
	

	public static void printArrayOneline(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
