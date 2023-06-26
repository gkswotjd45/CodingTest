package java_codingTest_연습;

import java.io.InputStreamReader;
import java.util.stream.IntStream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
	
public class Programmes_모의고사 {
	static class Solution {

		// 응시자들이 작성한 반복되는 답안 형태
		public static final int[][] RULES = { 
				{ 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 },{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		// 응시자의 인덱스와 문제 번호를 이용하여 제출한 답안 번호를 확인할 수 있음.
		public int getPicked(int persion,int problem) {
			int [] rule = RULES[persion];
			int index = problem % rule.length;
			return rule[index];
		}
	
		public int[] solution(int[] answers) {
			
			// 정답 개수를 나타내는 배열
			int[] corrects = new int [3];
			// 가장 많은 정답 개수 
			int max = 0;
			
			// 모든 문제를 순회하는 for문
			for(int problem = 0; problem < answers.length; problem ++) {
				int answer = answers[problem];
				for(int person= 0; person<3; person++) {
					int picked = getPicked(person, problem);
					if(answer == picked) {
						if(++corrects[person] > max) {
							max = corrects[person];
							
						}
					}
				}
			}
			
			final int maxCorrencts = max;
			return IntStream.range(0, 3)
					.filter(i -> corrects[i] == maxCorrencts)
					.map(i -> i+1)
					.toArray();
		}
		
	}
}
