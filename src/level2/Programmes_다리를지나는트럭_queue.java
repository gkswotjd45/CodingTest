package level2;

import java.util.LinkedList;
import java.util.Queue;
// 큐방식 
public class Programmes_다리를지나는트럭_queue {
	
	static class Solution {
		
		// 조건1. 다리에는 트럭이 최대 bridge_length대 만큼 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있음.
		// 조건2. 트럭이 다리에 올라가면 1초가 시작되는 것.
		// 조건3. 다리 위에서 1칸씩 움직일 때마다 1초씩 흘러감.
		
		// 큐가 비어있는 경우
		// = 다리에는 어떠한 트럭도 올라가지 않은 경우와 동일
		// 그냥 큐에 삽입해주면 됨. 또한 현재 다리에 있는 트럭무게를 저장할 sum 값에 트럭무가를 더해줌
		// 이후 트럭이 다리에 올라갔으므로 시간 +1
		
		// 큐가 가득차지 않은 경우
		// = 이때 이미 다리에 있는 트럭의 무게와 다리에 올릴 다음 트럭의 무게를 비교해 다리에 올릴지 말지를 결정
		// 최대 무게가 10, 현재 다리에 있는 트럭 무게는 7kg  투입할 트럭의 무게는 4kg
		// => 큐에 이미 있는 트럭이 다리를 지나갈 수 있도록 0 값을 넣어줌
		// if) 만약 다음 트럭이 3kg 이라면 전체 무게가 10이기 때무에 다음 트럭을 올리고, 현재 무게에 다음트럭의 무게를 더해줌
		// 이 경우 트럭을 0이든 nkg이든 올리기 때문에 시간 +1
		
		// 큐가 가득찬 경우
		// 이때는 가장 앞에 넣은 트럭이 다리의 끝에 도달했다는 의미로
		// poll 메서드를 이용해 트럭을 꺼내 줌으로써 다리를 건너도록 해줌.
		// 다리에 내릴때는 시간이 들지 않음.
		
		
		// 이 과정을 전체 트럭의 개수만큼 반복하면 됨.
		
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			Queue<Integer> queue = new LinkedList<>();
			int sum = 0; // 다리 무게 합
			int time = 0; // 소요 시간
			
			for(int i = 0; i< truck_weights.length; i++) {
				int truck = truck_weights[i];
				
				 // 큐에 아무것도 없는 경우
				while(true) {
					if(queue.isEmpty()) {
						queue.add(truck);
						sum += truck;
						time++;// 다리에 오를 때만 시간 추가
						break;
					// 큐에 다리길이 만큼 트럭이 다 찬 경우
					}else if(queue.size() == bridge_length) {
						sum -= queue.poll();
						
					// 다리 길이만큼 큐가 차지 않았음
					// weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
					}else {
						if(sum+truck <= weight) {
							queue.add(truck);
							sum+=truck;
							time++;
							break;
						// 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
						}else {
							queue.add(0);
							time++;
						}
						
					}
				}
			}
			// 마지막 트럭에서 반복문이 끝나는데, 마지막 다리 길이칸큼 나가야 하기에 + 다리길이
			return time + bridge_length;
		}
		
		
		
		
//		Queue<Integer> bridge = new LinkedList<>();
//		
//		int count = 0; // 들어가는 순번 
//		
//	    public int solution(int bridge_length, int weight, int[] truck_weights) {
//	    					      // 다리 길이   // 다리 무게    // 트럭 무게.
//	        int answer = 0; // 시간 초 의미
//	        for(int i=0; i<truck_weights.length;i++) {
//	        	
//	        	if(bridge.isEmpty()) { // 첫 순서인 경우
//	        	bridge.add(truck_weights[count]);
//	        	count++;
//	        	answer++;
//	        	}else if(bridge.peek()+truck_weights[count]<=weight && bridge_length>=bridge.size()) { // 무게가 넘지 않은 경우
//	        	  answer++;
//	        	  bridge.poll();
//	        	  bridge.add(truck_weights[count]);
//	        	  count++;
//	        	}else  { // 다리사이즈가 현재 크기을 넘어설 경우
//	        		answer++;
//	        		bridge.poll();
//	        	}
//	        }
//	        answer +=1; 
//	        return answer;
//	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int legth  = 2; 
		int weight = 10;
		int [] truck_weights = {7,4,6,8};
		System.out.println(solution.solution(legth, weight, truck_weights));

	}

}
