package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dijkstra {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int defaultVal = Integer.MAX_VALUE;

		// 정점과 간선의 수를 입력
		String[] input = br.readLine().split(" ");
		int nN = Integer.valueOf(input[0]);
		int eN = Integer.valueOf(input[1]);
		int distance[] = new int[nN + 1]; // 최단 거리를 저장할 변수
		boolean[] visited = new boolean[nN + 1];
		Arrays.fill(visited, Boolean.FALSE);// 해당 노드를 방문했는지 체크할 변수
		int eInfo[][] = new int[nN + 1][nN + 1];
		int startNode = -1;
		int endNode = -1;

		// 배열초기화
		init(eInfo, defaultVal);

		// 시작노드, 도착노드, 가중치
		for (int i = 0; i < eN; i++) {
			String[] input2 = br.readLine().split(" ");
			startNode = Integer.valueOf(input2[0]);
			endNode = Integer.valueOf(input2[1]);
			eInfo[startNode][endNode] = Integer.valueOf(input2[2]);
		}
		// 시작 노드 입력
		int searchPathStartNode = Integer.valueOf(br.readLine());

		dijkstra(distance, visited, eInfo, searchPathStartNode);
	}

	public static void dijkstra(int[] distance, boolean[] visited, int[][] eInfo, int startnode) {

		int node = startnode;
		visited[node] = true;
		

		for (int i = 1; i < eInfo[node].length; i++) {
			if (eInfo[node][i] < eInfo[i][node]) {
				distance[i] = eInfo[node][i];
			} else if (eInfo[node][i] > eInfo[i][node]) {
				distance[i] = eInfo[i][node];
			}else if( i == node) {
				distance[i] = 0;
			}
			else{
				distance[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i < visited.length-1; i++) {
			int min_val = Integer.MAX_VALUE;
			int min_idx = -1;
			for (int j = 1; j < distance.length; j++) {
				if (visited[j] == false && min_val > distance[j]) {
					min_val = distance[j];
					min_idx = j;
				}
			}

			visited[min_idx] = true;

			for (int k = 1; k < eInfo[min_idx].length; k++) {
				if (visited[k] == false && distance[k] > eInfo[min_idx][k] + min_val
						&& eInfo[min_idx][k] + min_val > 0) {
					distance[k] = eInfo[min_idx][k] + min_val;
				}
			}
			
		}
		for (int i = 1; i < distance.length; i++) {
			System.out.println(i + ": " + distance[i]);
		}
	}

	public static void init(int[][] arr, int defaultVal) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = defaultVal;
			}
		}
	}
}
