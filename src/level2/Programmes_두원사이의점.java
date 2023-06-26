package level2;

public class Programmes_두원사이의점 {
	static class Solution {
		public long solution(long r1, long r2) {
			// 총 원 안에 점 갯수
			long answer = 0;

			// 이중 반복문으로 하면 시간 초과가 나옴 O(n제곱)
			// 그럼 시간복잡도 O(n)을 만족하기 위해 두 좌표가 아닌, 하나의 좌표만을 가지고 계산해야한다고 생각했다.
			// 따라서 2차원 직교 좌표계 중 하나의 사분면만 계산한 뒤 4를 곱할 것.
			
			// 결국 r1원과 r2의 원사이에 있기 위해서는 적어도 r1보다 크고, r2보다 작은 길이가 되어야 함.
			
			// x가 1부터 시작하는 이유는. 정확히 넷으로 나누기 위해서
			// x축을 두 사분면이가지고, y축을 다른 두 사분면이 가져야 정확히 나눠지기 때문이다.
			// 그래서 1 ~ r2 까지임.
			for (long i = 1; i <= r2; i++) {
				//y1는 x제곱 + y제곱 <= 원의 반지름, 제곱을 만족하는 y의 최대값
				long y1 = (long) Math.floor(Math.sqrt(r2 * r2 - i * i));
				
			    //만약 i가 r1보다 크거나 같다면, 그 이후부터는 y2의 값이 0부터 시작한다.
			    //y2는 x^2 + y^2 >= r1 ^ 2를 만족하는 y의 최소값이다
				long y2 = (i >= r1) ? 0 : (long) Math.ceil(Math.sqrt(r1 * r1 - i * i));

				answer += y1 - y2 + 1;

			}
			return answer * 4;
		}

		public static void main(String[] args) {
			Solution solution = new Solution();
			System.out.println(solution.solution(50000, 1000000));

		}
	}
}
