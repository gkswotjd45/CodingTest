package java_codingTest_연습;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Progrrammes_완주하지못한사람들 {
	static class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> map = new HashMap<>(); 
	        // String 참가자 이름, Integer에는 기본적으로 Default 1 로 세팅
	        // 동명이인인 경우 추가적으로 구현.
	        
	        // 참가자를 해쉬 맵 형태로 삽입.
	        for(String player: participant) {
	        	map.put(player, map.getOrDefault(player, 0)+1);
	        	// map.getOrDefault는 player라는 key에 해당하는 Value가 있으면 가져오고, 아닐경우에 0으로 default로 지정하여 사용하겠다는 의미
	        	// 그러면 Value  값을 전부 1로 하면 되지 않을까 의문 => 동명이인 케이스도 생각.
	        	// 따라서 단순이 있다면 1. 없다면 0 으로 표현하는 것으로 부족하여 동일한 이름이 있다면 value 값을 1추가 하는 식으로 진행.
	        }
	        // 완주하는 사람들은 Integer 값을 1씩 빼기
	        for(String player : completion) {
	        	map.put(player, map.get(player)-1);
	        }
	        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
	        //Map에 있는 모든 Key-Value 쌍에 대한 반복자를 생성합니다. 이를 통해, Map의 각 요소에 접근하여 Key와 Value를 하나씩 가져올 수 있습니다.
	        
	        // 해쉬 맵의 Value값이 0을 찾아서 answer에 저장
	        while(iter.hasNext()) {
	        	Map.Entry<String, Integer> entry =iter.next();
	        	if(entry.getValue()!=0) {
	        		answer = entry.getKey();
	        		break;
	        	}
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
	      String[] part = {"leo", "kiki", "eden"};
	      String[] comp = {"eden", "kiki"};
	      Solution sol = new Solution();
	      System.out.println(sol.solution(part, comp));
	}
}
