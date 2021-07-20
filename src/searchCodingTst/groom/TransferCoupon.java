package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TransferCoupon {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcaseNumber = Integer.valueOf(br.readLine());
		Coupon[] coupons = new Coupon[testcaseNumber];
		int i = 0;
		while(testcaseNumber > i++) {
			String[] input = br.readLine().split(" ");
			coupons[i-1] = new Coupon(Long.parseLong(input[0]), Long.parseLong(input[1]), Long.parseLong(input[0])+Long.parseLong(input[1]));
		}
		
		int result[] = new int[testcaseNumber];
		int resultIdx = 0;
		int count = 0;
		for(Coupon c : coupons) {
			count = 0;

			while(c.season >= 5 && c.totalCount >= 12) {
				c.season = c.season - 5;
				c.totalCount = c.totalCount - 12;
				count++;
				
			}
			result[resultIdx] = count;
			resultIdx++;
		}
		
		printArray(result);
	}

	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}

class Coupon {
	
	public Long season;
	public Long normal;
	public Long totalCount;
	
	public Coupon(Long season, Long normal, Long totalCount) {
		this.season = season;
		this.normal = normal;
		this.totalCount = totalCount;
	}
}
