package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Programmes_과제진행하기 {
	static class Solution {
		HashMap<Integer, List<String>> map = new HashMap<Integer,List<String>>();  
	    
		public String[] solution(String[][] plans) {
	        String[] answer = new String[plans.length];
	        
	        for(int i = 0; i<plans.length; i++) {
	        	map.put(Integer.parseInt(plans[i][1]), new ArrayList<String>(Arrays.asList(plans[i][0],plans[i][2])));
	        }
	        
	        // 해쉬 맵 키 정렬
	        List<Integer> keySet = new ArrayList<>(map.keySet());
	        
	        // 키 값으로 오름찬순 정렬
	        Collections.sort(keySet);
	        
	        int index = 0;
	        for(int time : keySet) {
	        	
	        	if((time + Integer.parseInt(map.get(time).get(1)))>=keySet.get(index+1)){
	        		int check = keySet.get(index+1) - keySet.get(index);
	        		
	        	}
	        }
	        
	        
	        
//	        
//	        int [] time = new int [plans.length];
//	        for(int i= 0; i<plans.length; i++) {
//	        	time[i] = Integer.parseInt(plans[i][1]);
//	        }
//	        // 시간 순으로 정렬됨 // [1220,1230,1240,1400]
//	        Arrays.sort(time);
	        
	        
	        return answer;
	    }
	}
}
