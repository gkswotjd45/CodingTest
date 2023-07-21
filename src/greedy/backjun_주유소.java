package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjun_주유소 {
	static StringBuilder sb; // 결과값
	
	public static void gasstation() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int country = Integer.parseInt(br.readLine()); // 도시의 개수
		
		long distance [] = new long[country-1];
		long purePrice [] = new long[country];
		
		st = new StringTokenizer(br.readLine());
		// 도시에 대한 거리간격 저장
		for(int i=0; i<distance.length; i++) {
	
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		// 도시별 리터당 주유 가격
		for(int i=0; i<country; i++) {
		
			purePrice[i] = Long.parseLong(st.nextToken());
		}
		
		// 주유 총금액
		long sum = 0;
		long minCost = purePrice[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < country - 1; i++) {
			
//			  현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost를 갱신해준다. 
			
			if(purePrice[i] < minCost) {
				minCost = purePrice[i];
			}
			
			sum += (minCost * distance[i]);
		}
		
		sb = new StringBuilder();
		sb.append(sum + "\n");
		
	}
	
	public static void main(String[] args) throws Exception {
		gasstation();
		System.out.println(sb);
	}
}
