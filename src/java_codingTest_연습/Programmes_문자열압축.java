package java_codingTest_연습;

import java.util.ArrayList;
import java.util.List;

public class Programmes_문자열압축 {	
	static class Solution{
	  // 설정된 길이만큼 문자열을 잘라서 리스트에 담음
	  public List<String> split(String source, int length){
		  List<String> token = new ArrayList<>();
		  for(int startIndex = 0; startIndex<source.length(); startIndex += length) {
			  // 문자열을 startIndex 부터 잘라서 token 리스트에 추가
			  
			  // 마지막 인덱스는 초기시작위치 + 문자열 자르는 길이
			  int endIndex = startIndex + length;
			  if(endIndex>source.length()) endIndex = source.length(); //마지막 인덱스가. 원하는 문자열 길이 값에 초과한 경우라면
			  
			  token.add(source.substring(startIndex,endIndex));
		  }
		  return token;
	  }
		
	  // 압축한 문자열의 길이 반환
	  public int compress(String source, int length) {
		  StringBuilder sb = new StringBuilder();
		  
		  String last = ""; // 연속으로 중복된 문자열을 검사하기 위해 직전에 등장한 문자열을 담음
		  int count = 0; // 해당 등장횟수를 기록
		  for(String tk : split(source, length)) {
			  // 압축한 문자열 구성
			  if(tk.equals(last)) {// 이전 단어와 동일한 경우
				  count++;
			  } else { // 이전 단어와 동일하지 않은 경우
				  if(count>1) sb.append(count);
				  sb.append(last);
				  last = tk;
				  count = 1;
				  
			  }
			  
		  }
		  // 마지막 토큰을 last에 담긴 채 종료하지 않기 위해, 추가.
		  if(count>1) sb.append(count);
		  sb.append(last);
		  return sb.length();
	  }
	  public int solution(String s) {
	   
	        // 가장 짧은 압축 문자열의 길이 반환 변수. 초기값은 가장 큰값으로 설정.
	        int min = Integer.MAX_VALUE;
	        for(int length = 1; length<=s.length(); length++) {
	        	// 문자열 압축 후 가장 짧은 길이 선택
	        	int compressd = compress(s, length);
	        	if(compressd<min) {
	        		min = compressd;
	        	}
	        }
	        return min;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution("aabbaccc");
		System.out.println(result);
	}
}
