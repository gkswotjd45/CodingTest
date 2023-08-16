package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class beakjoon_최대힙 {
	static StringBuilder sb;
	
	static void maxHeap() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 우선 순위 큐 (최대 힙)
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		// 연산 횟수
		int test = Integer.parseInt(br.readLine());
		
		// 연산 진행
		for(int i=0; i<test; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num>0) {
				heap.add(num);
			}else if(num==0 && !heap.isEmpty()) {
				int max = heap.poll();
				sb.append(max).append("\n");
			}else {
				sb.append("0").append("\n");
			}
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		maxHeap();
		System.out.println(sb);
	}
}
