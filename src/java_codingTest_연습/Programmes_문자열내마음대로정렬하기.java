package java_codingTest_연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmes_문자열내마음대로정렬하기 {
	static class Solution {
	    public String[] solution(String[] strings, int n) {
//	        Arrays.sort(strings, (s1,s2)-> {
//	        	
//	        if(s1.charAt(n) != s2.charAt(n)) { // n번째 문자열이 다를 경우에만 비교
//	        	return s1.charAt(n) - s2.charAt(n);
//	        }
//			return s1.compareTo(s2); /// 그외는 사전순으로 문자열 정렬.
//	        	
//	        }); // n번문자를 가져와서 오름차순으로 정렬
//	        return strings;
	    	
	    	Arrays.sort(strings); // 받은 문자열을 사전에 오름차순으로 정룔
	    	String [] answer = new String[strings.length];
	    	
	    	for(int i = 0; i<strings.length; i++) {
	    	
	    		answer[i] = strings[i].substring(n,n+1);
	    	}
	    	Arrays.sort(answer);
	    	
	    	List<String> list = new ArrayList<>(Arrays.asList(strings));
	        for(int i = 0; i < answer.length; i++) {
	            for(int j = 0; j < list.size(); j++) {
	                if(list.get(j).substring(n, n+1).equals(answer[i])) {
	                    answer[i] = list.get(j);
	                    list.remove(list.get(j));
	                    break;
	                }
	            }
	        }
	       return answer;
	    }
	}
}
