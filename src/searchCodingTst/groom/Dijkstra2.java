package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int defaultVal = Integer.MAX_VALUE;

		// 1. 정점과 간선의 수를 입력
		String[] input = br.readLine().split(" ");
		int nN = Integer.valueOf(input[0]);
		int eN = Integer.valueOf(input[1]);
		
		int distance[] = new int[nN + 1]; // 최단 거리를 저장할 변수
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean visited[] = new boolean[nN+1];
		Arrays.fill(visited, false);
		int eInfo[][] = new int[nN + 1][nN + 1];
		//Arrays.fill(eInfo, Integer.MAX_VALUE);
		// 배열초기화
		init(eInfo, defaultVal);
		// 2. 시작노드, 도착노드, 가중치 입
		for (int i = 0; i < eN; i++) {
			String[] input2 = br.readLine().split(" ");
			int s = Integer.valueOf(input2[0]);
			int r = Integer.valueOf(input2[1]);
			int a = Integer.valueOf(input2[2]);
			eInfo[s][r] = eInfo[r][s] = eInfo[s][r] > a ? a:eInfo[s][r];
		}
		
		
		// 3. s시작 노드 입력
		int startNode = Integer.valueOf(br.readLine());
		
		PriorityQueue<Node> p = new PriorityQueue<Node>();
		
		p.offer(new Node(startNode, 0));
		distance[startNode] = 0;
		visited[startNode] = true;
		// 4. 현재 노드와 연결노드를 큐에 입력( 최소값기준으로 됨 )
		while(!p.isEmpty()) {
			Node current = p.poll();
			visited[current.vertex] = true;
			//연결된 정점들을 입력 , 이때 distance를 입력 
			for( int next = 1; next < eInfo[current.vertex].length; next++ ) {
				if(eInfo[current.vertex][next] != Integer.MAX_VALUE
						&& visited[next] == false) {
					p.offer(new Node(next, eInfo[current.vertex][next]));
					if( current.vertex != next && distance[next] > distance[current.vertex] + eInfo[current.vertex][next]) {
						distance[next] = distance[current.vertex] + eInfo[current.vertex][next];
					}
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

//node 는 distance의 역
class Node implements Comparable<Node> {

	public int vertex;
	public int distance;

	public Node(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		if (this.distance > o.distance)
			return 1;
		if (this.distance < o.distance)
			return -1;
		return 0;
	}
}
