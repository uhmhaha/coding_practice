package searchCodingTst.testdome;

import java.util.*;

public class RoutePlanner {
	
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
    	//For example: int[][] arr = {{1, 2}, {3, 4}};
		//    	1 2 
		//    	3 4
    	if(fromRow == toRow && fromColumn == toColumn ) {
    		return true;
    	}
    	
    	if(mapMatrix[fromRow][fromColumn] == false) {
    		return false;
    	}else if(mapMatrix[fromRow+1][toRow] == true ){
    		return routeExists(fromRow+1, fromColumn,toRow, toColumn, mapMatrix );
    	}else if(mapMatrix[fromRow+1][toRow] == true ) {
    		return routeExists(fromRow, fromColumn++,toRow, toColumn, mapMatrix );
    	}

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
