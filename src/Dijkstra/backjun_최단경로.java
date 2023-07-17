package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjun_최단경로 {

	static class Node implements Comparable<Node>{

		int end, weight; // 노드 순번 및 가중치

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		// 가중치가 낮은 순서부터 정렬 
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
		@Override
		public String toString() {
		    return "Node [end=" + end + ", weight=" + weight + "]";
		}
	}

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static final int INF = 100_000_000;
	static int v, e, k; // 정점의 개수, 간선의 개수, 시작 정점
	static List<Node>[] list;
	static int[] dist; // 다익스트라 [결과값]

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken()); // 정점의 개수
		e = Integer.parseInt(st.nextToken()); // 간선의 개수
		k = Integer.parseInt(br.readLine()); //시작 정점

		list = new ArrayList[v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, INF); // 초기화

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		// 리스트에 그래프 정보를 초기화
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 시작 노드
			int end = Integer.parseInt(st.nextToken()); // 연결된 노드
			int weight = Integer.parseInt(st.nextToken()); // 가중치

			list[start].add(new Node(end, weight));
		}
		StringBuilder sb = new StringBuilder();

		// 다익스트라 알고리즘
		
		   dijkstra(k);
	        // 출력 부분
	        for(int i = 1; i <= v; i++){
	            if(dist[i] == INF) sb.append("INF\n");
	            else sb.append(dist[i] + "\n");
	        }

	        bw.write(sb.toString());
	        bw.close();
	        br.close();

	}

	static void dijkstra(int start) {
	    PriorityQueue<Node> queue = new PriorityQueue<>();
	    boolean[] check = new boolean[v + 1];
	    queue.add(new Node(start, 0));
	    dist[start] = 0;

	    System.out.println("Initial queue: " + queue.toString());

	    while (!queue.isEmpty()) {
	        Node curNode = queue.poll();
	        int cur = curNode.end;
	        if (check[cur] == true)
	            continue;
	        check[cur] = true;

	        System.out.println("Current node: " + cur);
	        
	        for (Node node : list[cur]) {
	            if (dist[node.end] > dist[cur] + node.weight) {
	                dist[node.end] = dist[cur] + node.weight;
	                queue.add(new Node(node.end, dist[node.end]));
	                System.out.println("Updated distance for node " + node.end + ", new distance: " + dist[node.end]);
	                System.out.println("Updated queue: " + queue.toString());
	            }
	        }
	    }
	}
//	static void dijkstra(int start) {
//		PriorityQueue<Node> queue = new PriorityQueue<>();
//		boolean[] check = new boolean[v + 1];
//		queue.add(new Node(start, 0));
//
//		dist[start] = 0;
//
//		while (!queue.isEmpty()) {
//			Node curNode = queue.poll();
//			int cur = curNode.end;
//			if (check[cur] == true)
//				continue;
//			check[cur] = true;
//
//			for (Node node : list[cur]) {
//				if (dist[node.end] > dist[cur] + node.weight) {
//					dist[node.end] = dist[cur] + node.weight;
//					queue.add(new Node(node.end, dist[node.end]));
//				}
//
//			}
//
//		}
//
//	}
}
