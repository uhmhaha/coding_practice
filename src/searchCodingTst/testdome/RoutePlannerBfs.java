package searchCodingTst.testdome;

import java.util.LinkedList;
import java.util.Queue;

public class RoutePlannerBfs {
	
	public static boolean result = false;
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
    	
    	//1. 시작노드 설정
    	//2. 시작노드에서 연결된 방향이 잇는지 네가지 방향 체크/
    	//3. 연결방향을 시작노드로 설정
    	//4. 다시 네가지 방향을 체크(무한반복)
    	//5. 판단해서 toRow or toColumn동일한게 잇으면 true return 
    	
    	mapMatrix[fromRow][fromColumn] = false;
    	
    	if(fromRow == toRow && fromColumn == toColumn) {
    		result = result || true;
    		return result;
    	}
    	
		if( fromRow - 1 >=0 && mapMatrix[fromRow - 1][fromColumn] == true ) {
			routeExists(fromRow - 1, fromColumn, toRow, toColumn, mapMatrix);
		}
		
		if( fromColumn - 1 >=0  && mapMatrix[fromRow ][fromColumn - 1] == true ) {
			routeExists(fromRow , fromColumn -1, toRow, toColumn, mapMatrix);
		}
		
		if( fromRow + 1 <= toRow && mapMatrix[fromRow + 1 ][fromColumn] == true ) {
			routeExists(fromRow + 1, fromColumn, toRow, toColumn, mapMatrix);
		}
		if( fromColumn + 1 <= toColumn && mapMatrix[fromRow][fromColumn + 1] == true ) {
			routeExists(fromRow, fromColumn+1, toRow, toColumn, mapMatrix);
		}
		
		return result;
    	
    }
        
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };
        
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
