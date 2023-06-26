package level2;

public class Programmes_큰수만들기 {
	static class Solution {

		// ex) 4177252841 문자열을 4개 문자열을 제외한 가장 큰수를 만들라고 함. 즉 6자리 숫자중 가장 큰수를 구하여야 함
		// 먼저 내가 만들어야 할 수의 길이는 number.length() - k 의 길이만큼에 해당
		// 순서를 거르지 말고 6자리가 보장된 상태에서 진행
		
		
		// 1. 내가 뽑아야할 숫자의 개수는 6개 이므로, 맨뒤부터 5자리는 담겨둔다 
		// (why) 그래야 숫자 1개를 뽑더라도 뒤 5자리가 남아 무사히 6자리를 만들 수 있음
		// 2. 가장 큰수를 뽑아서 answer에 붙여둠 4177252841에서 52841을 빼고 41772에서 가장 큰수를 찾음
		// 3. 가장 큰수는 7이므로 answer에 붙여둠 7의 index는 2이므로 그 전의 문자는 다 지움.
		// 4. 417을 지운 후 나머지 문자열 7252841에서 '2841'을 제외한 가장 큰 수도 7임 
		// 5. answer = 77 에서 나머지 문자열 252841에서 '841'을 제외한 가장 큰수는 5임.
		// 6. answer = 775에서 나마지 문자열 2841에서 '41' 제외한 가장 큰수는 8임 
		// 7. answer = 7758에서 나머지 문자열 41에서 가장 큰수는 4를 선택하여 붙임
		// 8. answer = 77584 
		
		
		public String solution(String number, int k) {
			StringBuilder answer = new StringBuilder();
			int len = number.length() - k; // 만들어야할 문자(숫자) 자리수 
			int start = 0;
			
			// 입력받은 문자열 길이가 현위치보다 크거나, 답 문자열 길이와 만들어야할 문자 자리수 길이가 다를때 수행 
			while(start<number.length() && answer.length() != len) {
				int leftNum = k + answer.length()+1; // 현재 남아있는 문자열 인덱스 위치 
				int max = 0;
				for(int j = start; j<leftNum; j++) {
					// 가장 큰수를 골라서 그다음 인덱스 시작위치로 설정.
					if(max<number.charAt(j)-'0') {
						max = number.charAt(j) - '0';
						start = j+1;
					}
				}
				answer.append(Integer.toString(max));
			}
			return answer.toString();
		}
		
		
//		public String solution(String number, int k) {
//			String answer = "";
//			String checkNum = "";
//			long result = 0;
//			int max = 0;
//			int count = number.length() - k; // 얻을 수 있는 숫자 길이
//			for (int i = 0; i < number.length(); i++) {
//				checkNum += number.charAt(i) + "";
//				count--;
//				for (int j = i + 1; j < number.length(); j++) {
//					while (count > 0) {
//						checkNum += number.charAt(j) + "";
//						count--;
//					}
//					result = Math.max(max, Long.parseLong(checkNum));
//					count = number.length()-k -1;
//					// 여기에서 checkNum의 마지막 글자를 삭제하는 방식.
//				}
//
//			}
//			answer = Long.toString(result);	
//			return answer;
//		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.solution("1924", 2); // 94
		System.out.println(result);
	}
}
