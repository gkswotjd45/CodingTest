package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjun_ATM {
	static int N; // 배열 크기
	static int [] time;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		standbyTime();
		System.out.println(sb);
	}

	private static void standbyTime() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 배열 값을 저장하기 위한 토큰
		
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		// 대기시간을 오름차순으로 정렬,
		Arrays.sort(time);
		int total = 0;
		// 부분합 구하기 
		int prefix_sum[] = new int[N+1];
		for(int i = 0; i<N ; i++) {
			prefix_sum[i+1] = prefix_sum[i]+time[i];
			total += prefix_sum[i+1];
		}
		sb = new StringBuilder();
		sb.append(total);
	}
	
}
