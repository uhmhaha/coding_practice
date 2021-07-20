package searchCodingTst.backjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graphh {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	Graphh(int size) {
		nodes = new Node[size];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int i1, int i2) {
		Node node1 = nodes[i1];
		Node node2 = nodes[i2];

		if (!node1.adjacent.contains(node2)) {
			node1.adjacent.add(node2);
		}
		if (!node2.adjacent.contains(node1)) {
			node2.adjacent.add(node1);
		}
	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		Node root = nodes[index];

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;

		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					stack.add(n);
					n.marked = true;
				}
			}
			System.out.print(r.data+" ");
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Node root = nodes[index];

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		root.marked = true;

		while (!queue.isEmpty()) {
			Node r = queue.poll();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.offer(n);
				}

			}
			System.out.print(r.data+" ");
		}
	}
	
	void dfsR(Node r) {
		
		if(r.adjacent == null )
			return;
		r.marked = true;
		System.out.print(r.data+" ");
		for( Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int n) {
		Node r = nodes[n];
		dfsR(r);
	}
}


public class BfsDfs {
	public static void main(String[] args) {
		
		Graphh g = new Graphh(9);
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
		
		g.dfsR(0);
		
	}
}


