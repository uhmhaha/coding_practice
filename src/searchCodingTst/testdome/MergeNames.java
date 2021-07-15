package searchCodingTst.testdome;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        // Iteration using enhanced for loop
    	Set<String> Set = new HashSet<>();
    	
        for (String n1 : names1) {
            Set.add(n1);
        }
        
        for (String n2 : names2) {
            Set.add(n2);
        }
        String[] arr = new String[] {};
        
        return  Set.toArray(arr);
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
