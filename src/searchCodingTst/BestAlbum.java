package searchCodingTst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<Integer, Integer> firstRankMap = new HashMap<>();
        Map<Integer, Integer> secondRankMap = new HashMap<>();
        
        //1.가장 많이 재생된 장르계산
        for( int i = 0; i < genres.length; i++) {
        	if( genreMap.containsKey(genres[i])) {
        		int sum = genreMap.get(genres[i]) + plays[i];
        		genreMap.replace(genres[i], sum);		
        	}else {
        		genreMap.put(genres[i], plays[i]);
        	}
        }
//		for(String key : genreMap.keySet()) {
//			System.out.println(genreMap.get(key));
//		}
        //2. 가장 높은 재생된 장르계산
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(genreMap.entrySet());
		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
//		pop : 3100
//		classic : 1450
		//3. 각각 노래 담기 
		for( int i = 0; i < genres.length; i++) {
			if(genres[i].equals(list_entries.get(0).getKey())) {
				firstRankMap.put(i, plays[i]);
			}else if(genres[i].equals(list_entries.get(1).getKey())) {
				secondRankMap.put(i, plays[i]);
			}
		}
		// 결과 출력
		for(Entry<String, Integer> entry : list_entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
        List<Entry<Integer, Integer>> list_rank1_entries = new ArrayList<Entry<Integer, Integer>>(firstRankMap.entrySet());
		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_rank1_entries, new Comparator<Entry<Integer, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				// 내림 차순 정렬
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
		// 결과 출력
//		for(Entry<Integer, Integer> entry : list_rank1_entries) {
//			System.out.println(entry.getKey() + " : " + entry.getValue());
//		}
        List<Entry<Integer, Integer>> list_rank2_entries = new ArrayList<Entry<Integer, Integer>>(secondRankMap.entrySet());
		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_rank2_entries, new Comparator<Entry<Integer, Integer>>() {
			// compare로 값을 비교
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
		// 결과 출력
		for(Entry<Integer, Integer> entry : list_rank2_entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
        //3. 출력 
//		pop : 3100
//		classic : 1450
//		4 : 2500
//		1 : 600
//		3 : 800
//		0 : 500
//		2 : 150
		
		int[] answer = {list_rank1_entries.get(0).getKey(), 
						list_rank1_entries.get(1).getKey(),
						list_rank2_entries.get(0).getKey(),
						list_rank2_entries.get(1).getKey()};
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
