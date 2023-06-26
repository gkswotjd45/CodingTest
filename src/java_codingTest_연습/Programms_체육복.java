package java_codingTest_연습;

public class Programms_체육복 {
	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			answer = n; // 전체 학생수

			// 여벌의 체육복이 있었으나, 도난 당한 경우 각각 -1로 처리.
			// 빌려줄수 없다는 의미가 -1
			for (int i = 0; i < lost.length; i++) {
				for (int j = 0; j < reserve.length; j++) {
					if (lost[i] == reserve[j]) {
						lost[i] = -1;
						reserve[i] = -1;
					}
				}
			}

			// 체육복이 없는 배열을 돌면서 빌릴수 있는지 확인하고, 못빌려준다면 answer--
			for (int i = 0; i < lost.length; i++) {
				// 옷이 한번밖에 남지 않는 경우
				if (lost[i] == -1) {
					continue;
				}

				boolean rentalCheck = false;
				int j = 0;

				while (j < reserve.length) {
					// 대여 해줄 수 없을 경우
					if (reserve[j] == -1) {
						j++;
						continue;
					}
					// 여별의 체육복을 가져온 학생이 자기의 앞, 뒤 학생에게 체육복을 빌려줌
					if (lost[i] == (reserve[j] - 1) || lost[i] == (reserve[j] + 1)) {
						rentalCheck = true;
						reserve[j] = -1;
						break;
					} else {
						j++;
					}
				}
				if (!rentalCheck)
					answer--;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int lost[] = {2,4};
		int reverse[] = {1,3,5};
		System.out.println(solution.solution(5, lost, reverse));
	}

}
