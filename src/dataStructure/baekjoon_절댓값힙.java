package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon_절댓값힙 {
	static StringBuilder sb;

	public static void abstractHeap() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(
			(o1,o2) ->{
			int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;});
		// 연산자 개수
		int operatorNumber = Integer.parseInt(br.readLine());

		sb = new StringBuilder();

		for (int i = 0; i < operatorNumber; i++) {
			int num = Integer.parseInt(br.readLine());

			// 0이 아니라면
			if (num != 0) {
				queue.add(num);
			} else {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}

			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		abstractHeap();
		System.out.println(sb);
	}

}
