package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_계단오르기 {
	static StringBuilder sb;
	
	static void stair() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 계단의 총 개수 
		int rowTotal = Integer.parseInt(br.readLine());
		
		// 계단의 각 인덱스 별 합계
		int stair[] = new int [rowTotal];
		
		int score[] = new int [rowTotal];
		// 방문 여부
		boolean[] visited = new boolean[rowTotal];
		// 계단 초기화
		for(int i=0 ; i<rowTotal; i++) {
			int row = Integer.parseInt(br.readLine());
			stair[i] = row;
		}
		
		// 누적 합 초기화
		score[0] = stair[0];
		score[1] = stair[0]+stair[1];
		score[2] = Math.max(stair[0], stair[1]) + stair[2];
		
		for(int n = 3; n<rowTotal; n++) {
			score[n] = Math.max(score[n-3]+stair[n-1], score[n-2]) + stair[n];
		}
		
		sb = new StringBuilder();
		// 최종 결과값
		sb.append(score[rowTotal-1]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		stair();
		System.out.println(sb);
	}
}
