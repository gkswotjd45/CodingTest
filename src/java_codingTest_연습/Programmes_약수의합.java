package java_codingTest_연습;

public class Programmes_약수의합 {
	public static int solution(int n) {
		int answer = 0;
		int i = 1;
		boolean check = false;
		while(!check) {
			if ((n % i) == 0) {
				answer += i;
			}
			i++;
			if (n < i) {
				check = true;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
	
		System.out.println(solution(10));
	}
}