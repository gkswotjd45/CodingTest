package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class backjun_동전0 {
	static StringBuilder sb;

	public static void Calcul() throws Exception {
		int count = 0; // 총 개수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 결과값 전달
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int type = Integer.parseInt(st.nextToken()); // 동전 종류
		int total = Integer.parseInt(st.nextToken()); // 전체 금액
		Scanner sc = new Scanner(System.in);

		int coin[] = new int[type];

		for (int i = 0; i < type; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coin[i] = Integer.valueOf(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for (int i = coin.length - 1; i >= 0; i--) {
			if (total / coin[i] != 0) {
				min = total / coin[i];
				count += min;
				total %= coin[i];
			}
			if (total == 0) {
				break;
			}
		}
		sb.append(count + "\n");

	}

	public static void main(String[] args) throws Exception {
		Calcul();
		System.out.println(sb);
	}
}
