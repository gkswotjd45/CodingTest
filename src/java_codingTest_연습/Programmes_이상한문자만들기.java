package java_codingTest_연습;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Programmes_이상한문자만들기 {
	static class Soultuion {
		// 문자 이어서 붙이기
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        Boolean toUpper = true; // 공백문자가 다음에 대문자로 나타내기 위해 boolean
	        for(char c : s.toCharArray()) {
	        	// 문자가 알파벳이 아니면
	        	if(!Character.isAlphabetic(c)) {
	        		sb.append(c);
	        		toUpper = true;
	        	}else {
	        		// 문자가 소문자 알파벳이 맞는다면
	        		if(toUpper) {
	        			// 대문자로 변환해야 하면
	        			sb.append(Character.toUpperCase(c));

	        		}else {
	        			sb.append(Character.toLowerCase(c));
	        	
	        		}
	        		toUpper = !toUpper;
	        	}
	        }
	        return sb.toString();
	    }
	}
	public static void main(String[] args) throws IOException {
		Soultuion solution = new Soultuion();
		String result = solution.solution("try hello world");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(result);
		
		bw.flush();
		bw.close();
	}
}
