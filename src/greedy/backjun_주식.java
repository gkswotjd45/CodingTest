package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class backjun_주식 {
	static int T;
	static StringBuilder sb;
	
	public static void Calcul() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		T = Integer.parseInt(br.readLine());
		// 결과값 전달
		sb= new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			// 주식 개장 날
			int day;
			day = Integer.parseInt(br.readLine());
			// 주식 흐름 
			int stock[] = new int[day];
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < day; j++) {
				stock[j] = Integer.parseInt(st.nextToken());
			}
			// 주식 상한가 
			int Max = Integer.MIN_VALUE;
			
			// 수익
			long benefit = 0 ;  // 변경된 부분
			for(int k = stock.length-1; k>=0 ; k--) {
				
				// 처음 인덱스인 경우 
				if(k == stock.length -1) {
					 Max = stock[k];
				}
				// 현재 상한가보다 전날에 수치가 적을 경우
				if(Max> stock[k]) {
					benefit += Max-stock[k];
				}// 현재 상한가 보다 전날 수치가 큰 경우 
				else if(Max<stock[k]) {
					Max = stock[k];
				}
			}
			
			sb.append(benefit+"\n");
		}
		
	}
	public static void main(String[] args) throws Exception {
		Calcul();
		System.out.println(sb);
	}

}
