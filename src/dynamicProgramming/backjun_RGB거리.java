package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjun_RGB거리 {
	static StringBuilder sb;
	static int Red = 0;
	static int Green = 1;
	static int Blue = 2;
	static int [][] rgb;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int house = Integer.parseInt(br.readLine());
		
		rgb = new int[house][3]; // 이미 값 저장
		dp = new int[house][3]; // 누적 합 
		StringTokenizer st;

		for(int i = 0; i<house; i++) {
			st = new StringTokenizer(br.readLine()," ");
			rgb[i][Red] = Integer.parseInt(st.nextToken());
			rgb[i][Green] = Integer.parseInt(st.nextToken());
			rgb[i][Blue] = Integer.parseInt(st.nextToken());
		}
		
		// 누적 합의 첫번째 행은 각 색상비용의 첫 번째 값으로 초기화
		dp[0][Red] = rgb[0][Red];
		dp[0][Green] = rgb[0][Green];
		dp[0][Blue] = rgb[0][Blue];
		
		
		// house 인덱스번째에 색상 별 최소 값에 모든 경우의 수 구하기 
		System.out.println(Math.min(paintCost(house-1, Red), Math.min(paintCost(house-1, Green),paintCost(house-1, Blue))));
		
	}
	static int paintCost(int N, int color) {
		
		// 찾고자 하는 N번쨰의 인덱스 값이 아무것도 아직 없는 경우
		if(dp[N][color]== 0) {
			// 색상에 따라 이전 집의 서로 다른 색을 재귀 호출하여 최소값과 현재 집의 비용의 비용을 더해 DP에 저장.
			if(color == Red) {
				dp[N][Red] = Math.min(paintCost(N-1, Green), paintCost(N-1, Blue)) + rgb[N][Red];
			}
			else if(color == Green) {
				dp[N][Green] = Math.min(paintCost(N-1, Red), paintCost(N-1, Blue)) + rgb[N][Green];
			}
			else if(color == Blue) {
				dp[N][Blue] = Math.min(paintCost(N-1, Red), paintCost(N-1, Green)) + rgb[N][Blue];
			}
			
		}
		return dp[N][color];
	}
}
