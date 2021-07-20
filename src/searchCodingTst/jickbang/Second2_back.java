//package searchCodingTst.jickbang;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//import searchCodingTst.groom.Node;
//
//public class Second2_back {
//	/**
//	 * solution 정렬후 큰수부터 뽑아서 뽑은 번째 수를 곱한다.
//	 * 
//	 * @param args
//	 * @throws IOException
//	 */
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int cardNum = br.readLine().charAt(0) - '0';
//		
//		PriorityQueue<Number> queue = new PriorityQueue<Number>();
//		
//		String[] input = br.readLine().split(" ");
//		int[] numbers = new int[cardNum];
//		//numbers to integer
//		for( int i = 0; i < cardNum; i++){
//			numbers[i] = Integer.parseInt(input[i]);
//		}
//		//insert to queue
//		for( int j = 1; j<= numbers.length;j++) {
//			queue.offer(new Number(numbers[j]));
//		}
//		
//		System.out.println(calMaxval(queue));
//		
//	}
//	
//	public static int calMaxval(PriorityQueue<Number> queue) {
//		int lIdx = 0;
//		int rIdx = queue.size()-1;
//		
//		
//	}
//}
//
//class Number implements Comparable<Number> {
//
//	public int data;
//
//	public Number(int data) {
//		this.data = data;
//	}
//	@Override
//	public int compareTo(Number n) {
//		return this.data <= n.data ? 1 : - 1;
//	}
//}
