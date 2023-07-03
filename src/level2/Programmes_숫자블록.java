package level2;

public class Programmes_숫자블록 {
	static class Solution {
		
		public int[] solution(long begin, long end) {
			int beginInt = (int) begin;
			int endInt = (int) end;
			int idx = 0;
			
			int [] answer = new int [(endInt-beginInt + 1)];
			
			for(int i = beginInt; i<=endInt; i++) {
				// 소수 판별을 위한 변수
				boolean flag= false;
				
				// i가 1이면 지나감
				if(i==1) {
					answer[idx++]= 0;
					continue;
				}
				
				// 에라토테네스의 채로 소수인지 판별
				for(int j = 2; j*j<= i; j++) {
					//소수가 아니고 약수가 10000000 이하라면
					{
						if(i % j ==0 && i /j <= 100000000) {
							answer[idx++] = i/j;
							flag = true;
							break;
						}
					} 
				}
				
				// 소수라면 1 삽입
				if(!flag) {
					answer[idx++] = 1;
				}
				
	
			}
			return answer;
		}
		
//		// num에 대한 가장 큰 약수 구하는 메서드 
//		static public int IsPrime(int num) {
//			int max = 0;
//			
//			if(num == 2) {
//				return 1;
//			}
//			for(int i = 1; i< num; i++) {
//				if(num % i == 0) {
//					max = i;
//				}
//			}
//			return max;
//		}
//		
//		public int[] solution(long begin, long end) {
//			int[] answer = new int[(int) end];
//			
//			for(int i = (int) begin; i<end; i++) {
//				answer[i] = IsPrime(i+1);
//			}
//			return answer;
//		}
		
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(1, 10);

	}

}
