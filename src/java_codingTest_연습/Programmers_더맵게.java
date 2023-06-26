package java_codingTest_연습;

import java.util.PriorityQueue;

public class Programmers_더맵게 {
	static class Solution {
		
		
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> que = new PriorityQueue<>();

//	        가장 작은 값 2개를 배열에서 뽑는다.
//	        작은것과 두번째 작은것을 조건에 맞춰 계산한다.
//	        계산한 값을 다시 배열에 반환한다.
//	        배열의 값이 다 k보다 클 때 까지 반복한다.
	        
	        for(int i = 0; i<scoville.length; i++) {
	        	que.add(scoville[i]); // 해당 큐에 맨 뒤에 삽입.
	        }
	        while(que.peek()< K) { // 큐의 맨앞 요소가 k보다 작을 경우
	        	if(que.size()==1) {
	        		return -1;
	        	}
	        	que.add(que.poll() + que.poll() *2); // [해당 맨 앞칸 + 그 이후 다음 칸의 * 2] => 큐에 맨 앞에 삽입
	        	answer++;
	        }
	        return answer;
	       
	        
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr [ ] = {1, 2, 3, 9, 10, 12};
		solution.solution(arr, 7);
	}
}

//문제 설명
//매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
//모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
//Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 
//원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

//입출력 예
//scoville	        K(스코빌지수)	  => return
//[1, 2, 3, 9, 10, 12]	7	2
//입출력 예 설명
//스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
//가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
//
//스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
//가진 음식의 스코빌 지수 = [13, 9, 10, 12]


// 스코빌 지수를 만들기 위해 사용한 총 횟수 2번 