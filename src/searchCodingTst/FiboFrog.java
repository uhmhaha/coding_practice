package searchCodingTst;

import java.util.ArrayList;
import java.util.List;

//codility solution https://jackjeong.tistory.com/47
public class FiboFrog {
	
	final static List<Integer> fiboArr = new ArrayList<Integer>();
	
	public int solution(int[] A) {
		// write your code in Java SE 8
		
		//make fibo 
		return -1;
		
	}
	
	public static void makeFiboArr(int n) {
		fiboArr.add(fibo(n));
	}
	
	public static int fibo(int n) {
		if(n == 0) {
			//fiboArr.add(0);
			return 0;
		}
		if(n == 1) {
			//fiboArr.add(1);
			return 1;
		}
		int k = fibo(n-1) + fibo(n-2);

		fiboArr.add(k);
		return k;
	}
	
	public static void main(String[] args) {
		makeFiboArr(5);
		
		for(int i : fiboArr) {
			System.out.println(i);
		}
		
	}

}
