package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Programmes_귤고르기 {
	static class Solution {
		public int solution(int k, int[] tangerine) {
			int answer = 0;
//	        [1, 3, 2, 5, 4, 5, 2, 3]
			Arrays.sort(tangerine);
			// [1,2,2,3,3,4,5,5]
			Map<String, Integer> check = new HashMap<>();
			for (int i = 0; i < tangerine.length; i++) {
				check.put(Integer.toString(tangerine[i]), check.getOrDefault(Integer.toString(tangerine[i]), 0) + 1);
			}
			// 1:1, 2: 2, 3: 2, 4: 1, 5: 2

			// value 값으로 정렬
			List<Map.Entry<String, Integer>> entryList = new LinkedList<>(check.entrySet());
			// entryList.sort(Map.Entry.comparingByValue()); 오름차순 정렬
			entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed()); // 내림차순으로 정렬
			// 1:1, 4: 1, 2: 2, 3: 2, 5: 2

			for (Map.Entry<String, Integer> entry : entryList) {
				//System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
				if (k == 0)
					break;
				else if (k < entry.getValue()) {
					answer++;
					break;
				} else {
					k -= entry.getValue();
					answer++;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
		System.out.println(solution.solution(6, arr));

	}
}
