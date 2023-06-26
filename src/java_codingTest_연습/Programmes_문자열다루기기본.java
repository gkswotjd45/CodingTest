package java_codingTest_연습;

public class Programmes_문자열다루기기본 {
	static public class Solution {
		// 문자가 숫자로만 구성되어 있고, 길이가 4 or 6 인 경우에만 true
	    public boolean solution(String s) {
	    	// 1. 정규표현식으로 구하는 방식
//	    	return s.matches("[0-9]{4}||[0-9]{6}");
	    	
	    	if(s.length() != 4 && s.length() != 6) {
	    		return false;
	    	}
	    	for(char c : s.toCharArray()) {
	    		// 해당 문자가 숫자가 아닌 경우에는 false;
	    		if(!(Character.isDigit(c))) return false;
	    	}
	    	
	    	return true;
	    }
	} 
}
