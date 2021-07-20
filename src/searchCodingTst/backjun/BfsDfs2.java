package searchCodingTst.backjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph2 {
	class Node {
		int data;
		Stack<Node> adjcent;
		boolean marked;
		
		Node(int data){
			this.data = data;
			this.adjcent = new Stack<Node>();
			this.marked = false;
		}
	}

	Node[] nodes;
	Graph2(int size){
		nodes = new Node[size];
		
		for( int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {

		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjcent.contains(n2)) {
			n1.adjcent.push(n2);
		}
		
		if(!n2.adjcent.contains(n1)) {
			n2.adjcent.push(n1);
		}
	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		Node root = nodes[index];
		root.marked = true;
		
		Stack<Node> s = new Stack<Node>();
		
		s.push(root);
		
		while( !s.isEmpty()) {
			Node m = s.pop();
			
			for( Node n: m.adjcent) {
				if(n.marked ==false) {
					n.marked = true;
					s.push(n);
				}
			}
			System.out.print(m.data +" ");
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Node root = nodes[index];
		root.marked = true;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node no = q.poll();
			for( Node nod: no.adjcent) {
				if( nod.marked ==false) {
					nod.marked = true;
					q.offer(nod);
				}
			}
			System.out.print(no.data+" ");
		}
	}
	
	void dfsR(Node r) {
		if(r.adjcent == null)
			return;
		r.marked = true;
		System.out.print(r.data+ " ");
		for( Node n : r.adjcent) {
			if(n.marked == false)
				dfsR(n);
		}

	}
	
	void dfsR(int n) {
		Node node = nodes[n];
		dfsR(node);
	}
}


public class BfsDfs2 {
	public static void main(String[] args) {
		
		Graph2 g = new Graph2(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		//g.dfs(0);
		//g.bfs();
		g.dfsR(0);
		
	}
}


