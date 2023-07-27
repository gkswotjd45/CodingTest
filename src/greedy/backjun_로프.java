package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjun_로프 {
	static StringBuilder sb;
	
	public static void lope () throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine()); 
		int [] arr = new int[total]; 
		for(int i=0; i<total; i++) {
			arr[i] =Integer.parseInt(br.readLine()); 
		}
		
		// 로프의 무게르 오름 차순으로 정렬
		Arrays.sort(arr);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			
			// 혼자 단독으로 최대무게를 들을 수 있다면
			if(arr[i]>=max) {
				max = arr[i];
				
			}
			// 분산에서 나눌 수 있는 무게가 현재 최대무게보다 많이 들을 수 있는 경우
			if(arr[i]*total>= max) {
				max = arr[i]*total;
			}
			total--;
		}
		sb = new StringBuilder();
		sb.append(max);
		
	}
	public static void main(String[] args) throws IOException, Exception {
		lope();
		System.out.println(sb);
	}
}
