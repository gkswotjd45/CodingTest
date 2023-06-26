package java_codingTest_연습;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Programmes_가장큰수 {
	static class Solution {
	    public String solution(int[] numbers) {
	        
	        //먼저 숫자를 이어 붙일 수 있도록 모두 문자열로 변환.
	       return Arrays.stream(numbers).mapToObj(String::valueOf)
	        .sorted((s1,s2) -> {
	        	int original = Integer.parseInt(s1+s2);
	        	int reversed = Integer.parseInt(s2+s1);
	        	return reversed - original; // 반환값이 양수로 반환된다면 s2>s1 의미 => 내림차순 정렬.
	        })
	        .collect(Collectors.joining("")) //하나의 문자열로 구성
	        .replace("^0+", "0"); // 0으로만 구성된 경우 => 0인 문자열로 만 나타냄.
	        
	        
//	        public String solution(int[] numbers) {
//	            String answer = "";
//	            //문자열 리턴을 해줄 스트링배열 생성
//	            String[] str = new String[numbers.length];
//	            
//	            //int배열 String배열로 변환
//	            for(int i = 0; i < numbers.length; i++){
//	                str[i] = String.valueOf(numbers[i]);
//	            }     
//	            
//	            //내림차순 정렬
//	            Arrays.sort(str, new Comparator<String>() {
//	                @Override
//	                public int compare(String a, String b) {
//	                    return (b+a).compareTo(a+b);
//	                    //오름차순 정렬 (o1+o2).compareTo(o1+o2);
//	                }
//	            });
//	            
//	            //0값이 중복일경우 ex){0,0,0}
//	            //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
//	            if (str[0].equals("0")) r 
//	            //0이 아니면 문자열을 더해준다.
//	            for(String s: str) answer += s;
//	     
//	            return answer;
	    }
	}
}
