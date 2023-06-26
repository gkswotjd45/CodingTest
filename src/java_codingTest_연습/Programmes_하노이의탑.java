package java_codingTest_연습;

import java.util.ArrayList;
import java.util.List;

public class Programmes_하노이의탑 {
	static class Solutation {
		public List<int[]> hanoi(int n, int from, int to){
			// 종료 조건
			//if(n == 1) return List.of(new int[] {from, to}); // 원판이 한개만 남았을 경우, from에서 to로 이동시키는 건만 포함
			
			// 점화식 (반복해야할 식)
			int empty = 6 - from -to; // 초기 상태 (먼저 해야할 일) // 
			// empty는 빈 기둥을 의미, 위 하노이 탑의 전제 조건은 기등울 3개 사용해야 함.
			// if) 기둥을 1(from), 2(empty), 3(to) 으로 나타낼 때 6 = 기둥들의 합 => 따라서, 남은 기둥(empty)로 나타낼려면 
			// 6 - 1 - 3 = empty,  6 - from - to = empty
			
			List<int[]> result = new ArrayList<>();
			result.addAll(hanoi(n-1, from, empty)); // n-1개의 원판을 from or to가 아닌 빈기둥 empty 으로 옮기는 것 
			result.addAll(hanoi(1, from, to)); // 하나의 원판을 from 에서 to 기둥으로 옮기는 것.
			result.addAll(hanoi(n-1, empty, to)); // n-1개의 원판을 empty에서 to로 옮기는 것.
			return result;
		}
		   public int[][] solution(int n){
		        return hanoi(n,1,3).toArray(new int[0][]);
		    }
	}
}
