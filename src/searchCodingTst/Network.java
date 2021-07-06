package searchCodingTst;

public class Network {
	
	static boolean visited[];
	static int answer = 0;
	
    public static int solution(int n, int[][] computers) {
        
        visited = new boolean[computers.length];
        
        //initial visited array
        for( int i = 0; i < computers.length; i++) {
        	visited[i] = false;
        }
        
        for( int j = 0; j < visited.length; j++) {
        	if(visited[j] == false) {
        		dfs(j, n, computers);
        		answer++;
        	}
        }
        return answer;
    }
    
    public static void dfs(int node, int nV, int[][] computers) {
    	
    	visited[node] = true;
    	System.out.println("searching node is : "+ node + 1);
    	
    	for(int i = node; i <= node; i++) {
			for( int j = 0; j < nV; j++) {
				if(visited[j] == false && computers[i][j] == 1 && i != j)
					dfs(j, nV, computers);
			}
    	}
    }
    
    public static void main( String[] args) {
    	
    	int num = solution(3, new int[][] { {1,1,0}, {1,1,1}, {0,1,1}});
    	System.out.print(num);
    }
}
// 1  1  0  
// 1  1  0
// 0  0  1


//1  1  0  
//1  1  1
//0  1  1
