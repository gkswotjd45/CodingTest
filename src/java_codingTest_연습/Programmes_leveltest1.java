package java_codingTest_연습;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmes_leveltest1 {
	class Solution {
	    public String[] solution(String[] players, String[] callings) {
	        String[] answer = {};
	        int rank = 1;
	        Map<String, Integer> runner = new HashMap<>();
	        for(int i=0; i<players.length; i++) {
	        	runner.put(players[i], rank);
	        	rank++;
	        }
	        
	        Map<String, Integer> find = new HashMap<>();
	        for(int i=0; i<players.length; i++) {
	        	find.put(callings[i],find.getOrDefault(callings[i],1)+1);

	        }
	        Object[] mapkey = find.keySet().toArray();
			Arrays.sort(mapkey);
			
			for (String name : find.keySet()){
				if(runner.containsKey(name)) {
					int size = (Integer) runner.get(name);
					int size1 = (Integer) find.get(name);
					runner.put(name, size - size1);
				}
			}
	        
			
	        return answer;
	    }
	}
}
