package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class backjun_큐 {
	static StringBuilder sb;
	static int T;

	public static void queue() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 명령어의 총 수
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int node;
		StringTokenizer st;
		
		sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String commed = st.nextToken();
			if (commed.equals("push")) {
				node = Integer.parseInt(st.nextToken());
				queue.add(node);
			} else if (commed.equals("pop")) {
				if (!queue.isEmpty()) {
					node = queue.poll();
					sb.append(node + "\n");
				} else
					sb.append("-1" + "\n");
			} else if (commed.equals("size")) {
				node = queue.size();
				sb.append(node + "\n");
			} else if (commed.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append("1" + "\n");
				} else
					sb.append("0" + "\n");
			} else if (commed.equals("front")) {
				if (!queue.isEmpty()) {
					node = queue.getFirst();
					sb.append(node + "\n");
				} else {
					sb.append("-1" + "\n");
				}
			} else if (commed.equals("back")) {
				if (!queue.isEmpty()) {
					node = queue.getLast();
					sb.append(node + "\n");
				} else {
					sb.append("-1" + "\n");
				}
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		queue();
		System.out.println(sb);
	}
}
