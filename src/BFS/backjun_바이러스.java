package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjun_바이러스 {

	static StringBuilder sb;
	static ArrayList<ArrayList<Integer>> network = new ArrayList<>();
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	static boolean[] visited;
	static int answer;
	static void netWork() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int computer = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());

		StringTokenizer st;

		visited = new boolean[computer + 1];

		// 그래프 초기화 
		for(int k = 0; k<=computer; k++) {
			network.add(new ArrayList<>());
		}
		
		
		// 그래프값 저장.
		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			network.get(v).add(g);
			network.get(g).add(v);
		}

		// 그래프 오름차순 정렬
		for (int i = 0; i < computer; i++) {
			Collections.sort(network.get(i));
		}
		int startIndex = 1;
		sb = new StringBuilder();
		int total = BFS(startIndex);
		
		sb.append(total);

	}

	private static int BFS(int startIndex) {
		// 방문노드 처리
		visited[startIndex] = true;
		// 해당 노드 큐에 삽입
		queue.add(startIndex);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			// 해당 노드와 연결되어 있는 모든 노드 queue에 넣기
			for (int node : network.get(cur)) {
				// 만약 해당 노드를 방문하지 않았다면
				if (visited[node] == false) {
					// 큐에 넣기
					queue.add(node);
					// 해당 노드를 방문처리하기
					visited[node] = true;
					// 연결되어 있는 간선 개수 추가
					answer++;
				}

			}

		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		netWork();
		System.out.println(sb);
	}
}
