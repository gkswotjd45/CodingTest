package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon_최소힙 {
	static StringBuilder sb;
	
	static void minHeap() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 우선 순위 큐 생성
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		// 연산 수행
		int test = Integer.parseInt(br.readLine());
		
		int [] arr = new int[test]; 
		
		// 연산 수행
		for(int i=0, index = 0; i<test ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num >0) {
				// 큐 안에 값 삽입
				queue.add(num);
			}else if (num == 0  && !queue.isEmpty()) {
				// 큐에 있는 값 확인
				 int min = queue.poll();;
				 sb.append(min).append("\n");
				
			} else {
				sb.append("0").append("\n");
			}
			
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		minHeap();
		System.out.println(sb);
	}
}
