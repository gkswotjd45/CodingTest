package java_codingTest_연습;

import java.util.HashMap;
import java.util.Map;

public class Programmes_가장가까운글자찾기 {
	static class Solution {
		public int[] solution(String s) {
//			int[] answer = new int[s.length()];
		
			 String[] strArr = s.split(""); //문자열 s을 문자 단위로 strArr 에 저장.
		        Map<String, Integer> strMap = new HashMap<String, Integer>();
		        int[] answer = new int[strArr.length];
		        
		        for(int i=0; i<strArr.length; i++){
		            // hashmap에 동일한 글자가 없다면 answer배열에 -1추가
		            if(strMap.get(strArr[i]) == null){
		                answer[i] = -1;
		            }else {
		            	// 만약 동일한 글자가 있다면 해당 인덱스 
		                answer[i] = i - strMap.get(strArr[i]);
		            }
		            strMap.put(strArr[i], i);
		        }
		        
		        return answer;
// 다른 풀이
//	        for (int i = 0; i < s.length(); i++) {
//				for (int j = i; j >= 0; j--) {
//					if (s.charAt(i) == s.charAt(j) && answer[i] == 0) {
//						answer[i] = i - j;
//						
//					}
//				}
//				if (answer[i] == 0) {
//					answer[i] = -1;
//				}
//			}
//	        
//			HashMap<Character, Integer> check = new HashMap<>();
//			
//			for (int i = 0; i < s.length(); i++) {
//				char c = s.charAt(i);
//				if (!check.containsKey(c)) {
//					check.put(c, 0);
//					answer[i] = -1;
//				} else {
//					int move =  check.get(c) + i-1;
//				}
//			}

//			return answer;
		}
	}
}
