package searchCodingTst.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//
//DFS
//
//Stack 혹은 재귀함수(Recursion)으로 구현된다.
//
//경로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게되면 다른 방향으로 다시 탐색을 진행
//모든 노드를 방문하는 경우에 이 방법을 사용한다.
//시간 복잡도
//인접 리스트 : O(V + E)
//인접 행렬 : O(V^2)

//BFS
//Queue를 사용해서 구현한다.
//
//시간 복잡도
//인접 리스트 : O(V + E)
//인접 행렬 : O(V^2)
//BFS는 다음의 경우 효과적으로 풀이할 수 있다.
//
//1. 최소 비용 문제
//2. 간선의 가중치가 1인 경우
//3. 정점과 간선의 개수가 적다. (시간 제약, 메모리 제한 내에 만족한다.)

//이 문제는 1번째 조건과 최단거리 조건이 만족 때문에 DFS로 풀이하면 시간초과가 나게된다...
//DFS로 풀다가 삽질을 많이 한 문제이다. 
//https://dragon-h.tistory.com/15 백준 해결관련 
//참고 : https://dragon-h.tistory.com/15
//참고2 : https://www.acmicpc.net/problem/2178

public class MiroSearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 배열 수를 입력
		String arrXY = br.readLine();
		int row = arrXY.charAt(0) - '0';
		int col = arrXY.charAt(2) - '0';

		int pathInfo[][] = new int[row + 1][col + 1];

		// 2. 각 길에 대한 정보입력
		for (int i = 1; i <= row; i++) {
			String val = br.readLine();
			for (int j = 1; j <= col; j++) {
				pathInfo[i][j] = val.charAt(j - 1) - '0';
			}
		}

		bfs(pathInfo, 1, 1, row, col);
		// printArray(pathInfo);
	}

	public static void bfs(int pathInfo[][], int x, int y, int row, int col) {

		MyNode nd = new MyNode(x, y);
		int isVisited[][] = new int[row + 1][col + 1];

		Queue<MyNode> q = new LinkedList<>();
		q.offer(nd);
		isVisited[1][1] = 1;
		// 상하좌우 칸을 표현하는데 사용할 배열
		int[] xArr = { -1, 0, 1, 0 };
		int[] yArr = { 0, 1, 0, -1 };
		
		while (!q.isEmpty()) {
			MyNode mn = q.poll();

			int nx = mn.x;
			int ny = mn.y;

			// 연결된것을 찾는다.
			for (int k = 0; k < xArr.length; k++) {
				int xx = nx + xArr[k];
				int yy = ny + yArr[k];
				if (checkNode(isVisited, pathInfo, xx, yy, row, col)) {
					q.add(new MyNode(xx, yy));
					isVisited[xx][yy] = isVisited[nx][ny] + 1;
				}

			}
		}
		System.out.println(isVisited[row][col]);
	}

	public static boolean checkNode(int isVisited[][], int pathInfo[][], int x, int y, int row, int col) {
		// 방문햇는지, 길이잇는지, 음수가 아닌지
		if (x < 1 || y < 1 || x > row || y > col)
			return false;
		if (pathInfo[x][y] == 0 || isVisited[x][y] != 0)
			return false;
		return true;
	}

	public static void printArray(int[][] arr) {

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				System.out.println(i + "," + j + " : " + arr[i][j]);
			}
		}
	}

}

class MyNode {
	int x;
	int y;

	MyNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
