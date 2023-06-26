package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Programmes_기능개발_hashMap {
	static class Solution {
		Stack<Integer> code = new Stack<>();
		HashMap<Integer, Integer> result = new HashMap<>();
		public int[] solution(int[] progresses, int[] speeds) {
			
			
			for (int i = 0; i < progresses.length; i++) {
				// (100-93) /1 = 7 , (100-30) /30 = 2.4 => 3, (100-55) / 5 = 9
				if (code.isEmpty()) {
					code.push((int) Math.ceil(((100 - progresses[i]) /(double) speeds[i])));
				} else if (code.peek() >= (int) Math.ceil((100 - progresses[i]) /(double) speeds[i])) {
					code.push(code.peek());
				}else {
					code.push((int) Math.ceil(((100 - progresses[i]) /(double) speeds[i])));
				}
				//System.out.println(code);
			}
			// 중복 제거를 위한 값을 취함
			for(int a :code) {
				result.put(a, result.getOrDefault(a, 0)+1);
				System.out.println(result);
			}
	        List<Integer> keySet = new ArrayList<>(result.keySet());
	        // 키 값으로 오름차순 정렬
	        Collections.sort(keySet);
	        
	        int [] answer = new int[keySet.size()];
	        int index = 0;
	        for (int key : keySet) {
	            answer[index++] = result.get(key);
	        }

			return answer;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] progress = {100,50,99,100};
		int [] speeds = {1,1,1,1};
		int reult [] = solution.solution(progress,speeds);
		for(int a:reult) {
			System.out.println(a);
		}
		
	}
}
