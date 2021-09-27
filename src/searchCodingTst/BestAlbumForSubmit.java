package searchCodingTst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbumForSubmit {
    public static int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<Integer, Integer> firstRankMap = new HashMap<>();
        Map<Integer, Integer> secondRankMap = new HashMap<>();
        
        for( int i = 0; i < genres.length; i++) {
        	if( genreMap.containsKey(genres[i])) {
        		int sum = genreMap.get(genres[i]) + plays[i];
        		genreMap.replace(genres[i], sum);		
        	}else {
        		genreMap.put(genres[i], plays[i]);
        	}
        }
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(genreMap.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		for( int i = 0; i < genres.length; i++) {
			if(genres[i].equals(list_entries.get(0).getKey())) {
				firstRankMap.put(i, plays[i]);
			}else if(genres[i].equals(list_entries.get(1).getKey())) {
				secondRankMap.put(i, plays[i]);
			}
		}
		
        List<Entry<Integer, Integer>> list_rank1_entries = new ArrayList<Entry<Integer, Integer>>(firstRankMap.entrySet());
		Collections.sort(list_rank1_entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
                if (obj2.getValue() < obj1.getValue()) {
                    return -1;
                } else if (obj2.getValue() > obj1.getValue()) {
                    return 1;
                } else if ( obj2.getValue() == obj1.getValue()) {
                	if( obj2.getKey() > obj1.getKey()) {
                		return 1;
                	}else {
                		return -1;
                	}
                }
                return 0;
			}
		});
        List<Entry<Integer, Integer>> list_rank2_entries = new ArrayList<Entry<Integer, Integer>>(secondRankMap.entrySet());
		Collections.sort(list_rank2_entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				// 내림 차순 정렬
                if (obj1.getValue() < obj2.getValue()) {
                    return 1;
                } else if (obj1.getValue() > obj2.getValue()) {
                    return -1;
                } else if ( obj1.getValue() == obj2.getValue()) {
                	if( obj1.getKey() > obj2.getKey()) {
                		return 1; //switch true
                	}else {
                		return -1; //switch false
                	}
                }
                return 0;
			}
		});
		
		List<Integer> numList = new ArrayList<>();
		
		for( int i = 0; i < list_rank1_entries.size() && i < 2; i++) {
			numList.add(list_rank1_entries.get(i).getKey());
		}
		
		for( int i = 0; i < list_rank2_entries.size() && i < 2; i++) {
			numList.add(list_rank2_entries.get(i).getKey());
		}
		
		int[] answer = new int[numList.size()];
		for( int i = 0; i < numList.size(); i++) {
			answer[i] = numList.get(i);
		}
        return answer;
    }
    
//    ["classic", "pop", "classic", "classic", "pop"]	
//    [500, 600, 150, 800, 2500]	
//    		[4, 1, 3, 0]
    public static void main(String[] args) {
    	int[] result = solution(
    							new String[] {"classic", "pop", "classic", "classic", "pop"},
    							new int[] {500, 600, 150, 800, 2500} );  
    	printArray(result);
    }
    
    public static void printArray( int[] arr) {
    	System.out.print("arrays : ");
    	
    	if(arr.length == 0) {
    		System.out.println("[0,0]");
    		return;
    	}
    	
    	System.out.print("[");
    	
    	for(int i = 0; i < arr.length; i++ ) {
    		
    		System.out.print(arr[i]);
    		
    		if( i != arr.length -1) {
    			System.out.print(",");
    		}
    	}
    	System.out.print("]");

    }

}
