package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjun_DFS와BFS {
	static StringBuilder sb; // 결과값
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	static boolean DFSvisited[];
	static boolean BFSvisited[];

	public static void practice() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int Node = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		DFSvisited = new boolean[Node+1];

		// 그래프 초기화
		for (int i = 0; i <= Node; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 저장
		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 그래프 오름차순
		for (int i = 0; i <= Node; i++) {
			Collections.sort(graph.get(i));
		}
		sb = new StringBuilder();
		DFS(start);
		
		sb.append("\n");
		
		BFSvisited = new boolean[Node + 1];
		BFS(start);

	}

	public static void DFS(int indexNode) {
		DFSvisited[indexNode] = true;
		sb.append(indexNode + " "); // 방문한 결과 출력
		for (int i = 0; i < graph.get(indexNode).size(); i++) {
			int newNode = graph.get(indexNode).get(i);

			if (DFSvisited[newNode] == false) {

				DFS(newNode);
			}
		}
	}

	public static void BFS(int indexNode) {
		BFSvisited[indexNode] = true;
		sb.append(indexNode + " "); // 방문 결과 추가 
		queue.add(indexNode); // 큐에 시작 노드 저장

		// 큐에 아무것도 없을 때 까지 진행
		while (!queue.isEmpty()) {
			int cur = queue.poll(); // 큐에 가장 상위에 넣은 노드를 꺼냄

			for (int next : graph.get(cur)) {
				if (!BFSvisited[next]) { // 이어진 점이 방문한 곳이 아니면
					BFSvisited[next] = true; // 방문 처리하고
					sb.append(next + " "); // 방문 경과 추가
					queue.add(next); // 큐에 방문한 정점을 저장
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		practice();
		System.out.println(sb);
	}
}
