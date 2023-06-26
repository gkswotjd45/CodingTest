package level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class Programmes_베스트앨범 {

	static class Solution {
		static int max;
	    public int[] solution(String[] genres, int[] plays) {
	        int[] answer = new int[genres.length];
	        HashMap<String, Integer> type = new HashMap<>();
	        HashMap<String, Integer> playing = new HashMap<>();
	        
	        max = 0; // 가장 많이 재생된 수
	        
	        // hash map = class - 3, pop -2
	        for(String name : genres) {
	        	type.put(name,type.getOrDefault(name,0)+1);
	        }
	        
	        // hash map = class 500, pop 600, class 150, class 800, pop - 2500
	        int i = 0;
	        for(int song : plays) {
	        	// 가장 많이 재생한 수 구하기 
	        	if(max <= song) { max = song;}
	        	playing.put(genres[i],song);
	        	i++;
	        }
	        
	        getKey(type,max);
	        
	        return answer;
	    }
	    
	    
	    // value 값으로 key값 찾는 메서드
	    public static <K, V> K getKey(Map<K, V> map, V value) {
	        // 찾을 hashmap 과 주어진 단서 value
	        for (K key : map.keySet()) {
	            if (value.equals(map.get(key))) {
	                return key;
	            }
	        }
	        return null;
	    }

	    
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
