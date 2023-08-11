package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon_수들의합 {
	StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자연수의 합
		long s = Long.parseLong(br.readLine());

		// 자연수의 총 개수
		int result = search_N(s);

		System.out.println(result);

	}

	private static int search_N(long s) {
		// 자연수의 개수
		int N = 0;
		// 자연 수의 합계
		long sum = 0L;
		int i = 1; // 1부터 시작

		while (true) {
			sum += i++;
			if (sum > s) {
				return N;
			}
			N++;
		}
	}
}
