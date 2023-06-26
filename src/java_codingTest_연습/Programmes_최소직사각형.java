package java_codingTest_연습;

public class Programmes_최소직사각형 {

	static class Solution {

		public int solution(int[][] size) {
			//size은 2차원 배열이고 size.length 는 size의 row(행)의 개수를 의;미
			// size[0].length 은 1번째 행의 열의 개수를 의미
			int anwser = 0;
			int max_v = 0; // 가로의 가장 긴 값
			int max_w = 0; // 세로의 가장 짧은 값
			
			for(int i = 0; i<size.length; i++) {
				int v = Math.max(size[i][0], size[i][1]);
				int h = Math.min(size[i][0], size[i][1]);
				
				max_v = Math.max(max_v,v);
				max_w = Math.max(max_w,h);
			}
			
			return anwser = max_v * max_w;
			
		}
	}

	
	//접근법 => 명함은 회전할 수 있다.
	//가로 : 두 변중에서 가장 긴부분, 세로: 두 변중에서 작은 부분으로 찾아서, 각각 곱하면 결과가 도출.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
