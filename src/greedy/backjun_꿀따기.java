package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjun_꿀따기 {
	static int T ; // 배열의 크기
	static StringBuilder sb; // 답 저장.
	static int honey[];
	public static void Honey() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 배열 값을 저장하기 위한 token 
		
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 항목 값 받기
		
		honey= new int[T]; // 배열의 꿀 값 저장하기
		for(int i = 0; i< T; i++) {
			honey[i] = Integer.parseInt(br.readLine());
		}
		
		int Max = Integer.MIN_VALUE; // 최대값 저장
		
		// 경우의 수는 총 3가지 각 항목에 대한 값을 구한 다음, 값들 중 최대값을 가져와서 보여줌
		
		// 경우의 수 1번째 벌, 벌, 꿀
		for(int j = 0; j<honey.length; j++) {
		
			// 첫 번재 벌의 수집 값
			int e1 = Sum(honey.length) - honey[j] - honey[0];
			// 두 번째 벌의 수집 값
			int e2 = Sum(honey.length) - Sum(j);
		}
		
		
		
		
	} 	
	
	// 누적합 
	private static int Sum(int length) {
		
		int sum = 0;
		for(int i = 0; i<length; i++) {
			sum += honey[i];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		Honey();
		System.out.println(sb);
	}
}
