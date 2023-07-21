package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjun_회의실배정 {
	static StringBuilder sb; // 결과값

	static void assignment() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int totalTime = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		int Time[][] = new int[totalTime][2];

		for (int i = 0; i < totalTime; i++) {
			st = new StringTokenizer(br.readLine());

			Time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			Time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}

		int max = 0; // 최대 회의실 사용 횟수

		int count = 0;

		// 1번째 요소 기준으로 오름차순 => 회의가 끝나는 시간을 기준으로 오름차순
		// 만약 동일하면 0번쨰 요소 비교
		Arrays.sort(Time, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < Time.length; i++) {
			if (i == 0) {
				count = Time[i][1];
				max++;
				continue;
			}
			if(Time[i][0] >= count) {
				count = Time[i][1];
				max++;	
			}
		}
		
		sb.append(max+"\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		assignment();
		System.out.println(sb);
	}

}
