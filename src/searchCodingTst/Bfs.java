package searchCodingTst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
	
	public static int nV;
	public static int nE;
	
	public static int[][] arr2d;
	public static boolean [] check;
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		check[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.println("visited node is : "+ temp);
			
			for( int j = 1; j < nV+1; j++) {
				if(arr2d[temp][j] == 1 && check[j] == false) {
					q.offer(j);
					System.out.println("push node is : "+ j);
					check[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		nV = scan.nextInt();
		nE = scan.nextInt();
		
		arr2d = new int[nV+1][nV+1];
		check = new boolean[nV+1];
		
		for( int i = 0; i < nE; i++) {
			int temp1 = scan.nextInt();
			int temp2 = scan.nextInt();
			
			arr2d[temp1][temp2]= arr2d[temp2][temp1] = 1;
		}
		
		System.out.print("탐색시작위치 입력 --> : ");
		int start = scan.nextInt();
		bfs(start);
	}

}
//https://seeminglyjs.tistory.com/255
//입력 예제
//4 4
//1 2
//1 4
//2 3
//3 4
//
//1
