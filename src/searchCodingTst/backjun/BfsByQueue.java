package searchCodingTst.backjun;

import java.util.LinkedList;

class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		Node(int data){
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	Graph(int size){
		nodes = new Node[size];
		for( int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		  Node node1 = nodes[i1];
		  Node node2 = nodes[i2];
		  
		  if(!node1.adjacent.contains(node2)) {
			  node1.adjacent.add(node2);
		  }
		  if(!node2.adjacent.contains(node1)) {
			  node2.adjacent.add(node1);
		  }
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int n) {
		
	
	}
}
