package java_codingTest_연습;

import java.util.Arrays;
import java.util.Collections;

public class Programmes_문자열내림차순으로정렬 {
	static class Solutaion {
		public String solution(String s) {
//
//		        return s.chars().boxed().sorted((v1,v2) -> v2 - v1).collect(StringBuilder::new, StringBuilder::appendCodePoint,
//		        		StringBuilder::append).toString(); //IntStream으로 변환하고, Stream<Integer>로 변환 
//		        
//		    }
			String answer = "";
			String[] str = s.split(""); // 띄어쓰기없이 String 배열에 저장\
			Arrays.sort(str, Collections.reverseOrder()); // 뒤로 정렬.

			for (String a : str) {
				answer += a;
			}
			
			return answer;
		}

	}

	public static void main(String[] args) {
		Solutaion solutaion = new Solutaion();
		String result = solutaion.solution("Zbcdefg");
		System.out.println(result);
	}
}
