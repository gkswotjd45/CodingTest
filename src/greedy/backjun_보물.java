package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjun_보물 {
	static int T; // 배열 개수
	static StringBuilder sb;

	static void gold() throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int aArr[] = new int[T];
		int bArr[] = new int[T];
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			aArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			bArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] cArr = Arrays.stream(bArr).boxed().toArray(Integer[]::new);
		
		// A배열 오름차순
		Arrays.sort(aArr);

		// B배열 내림차순
		Arrays.sort(cArr, Collections.reverseOrder());
		int sum = 0;
		for (int i = 0; i < T; i++) {
			sum += aArr[i] * cArr[i];
		}

		sb.append(sum + "\n");

	}

	public static void main(String[] args) throws Exception {
		gold();
		System.out.println(sb);
	}

}
