package searchCodingTst.basicjava;

public class DynamicPrograming {
	public static void main(String[] args) {
		
		System.out.print(fibo(5));
		
	}

	private static int fibo(int i) {

		if(i == 0) {
			return 0;
		}
		if(i == 1) {
			return 1;
		}
		return fibo(i-1) + fibo(i-2);
	}
}
