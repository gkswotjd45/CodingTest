package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_줄세우기 {
	static StringBuilder sb;

	public static void lineSort() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// 사람 수
		int person = Integer.parseInt(st.nextToken());

		// 비교할 수 있는 횟수
		int comparison = Integer.parseInt(st.nextToken());

		// 위상 정렬에 사용할 진입차수 저장 배열
		// person은 1번 인덱스 부터 시작하므로
		int[] edgeCount = new int[person + 1];

		// 위상 정렬에 사용할 그래프 (2차원 리스트로 초기화)
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < person + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 위상정렬에 사용할 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 그래프에 각 노드별 인접한 노드 초기화 [키를 비교할 수 있는 형태]
		for (int i = 0; i < comparison; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph.get(from).add(to);

			// 진입 차수 초기화
			edgeCount[to]++;
		}

		// 진입 차수가 0인 노드를 큐에 삽입
		for (int i = 1; i < edgeCount.length; i++) {
			if (edgeCount[i] == 0) {
				queue.offer(i);
			}
		}
		sb = new StringBuilder();
		while(!queue.isEmpty()) {
			// 큐에 현재 남겨져 있는 노드 가져오기
			int currentNode = queue.poll();
			// 결과값 출력
			sb.append(currentNode).append(" ");
			// 꺼낸 노드의 인접한 노드들 찾기
			List<Integer> list = graph.get(currentNode);
			
			//인접한 노드의 개수 만큼 반복문 실행.
			for(int i=0;i<list.size(); i++) {
				// 인접한 노드 접입 차수 갱신
				edgeCount[list.get(i)]--;
				// 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
				if(edgeCount[list.get(i)] == 0) {
					queue.add(list.get(i));
				}
			}
				
		}
	}

	

	public static void main(String[] args) throws IOException {
		lineSort();
		System.out.println(sb);
	}
}
