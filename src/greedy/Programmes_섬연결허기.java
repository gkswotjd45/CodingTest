package greedy;

import java.util.*;

public class Programmes_섬연결허기 {

    static class Solution {
    	static int[] parent;
    	 
    	public int solution(int n, int[][] costs) {
    		//크루스칼 알고리즘을 사용하기 위해 가중치 기준 오름차순 정렬
    		Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);
    		
    		//Union find를 사용하기 위해 parent 배열 선언
    		parent = new int[n];
    		
    		for(int i=0; i<n; i++) {
    			parent[i] = i; //처음에는 자기 자신으로 부모를 초기화
    		}
     
    		int total = 0;
    		for(int[] edge: costs) {
    			int from = edge[0];
    			int to = edge[1];
    			int cost = edge[2];
     
    			int fromParent = findParent(from);
    			int toParent = findParent(to);
     
    			//부모노드가 같으면(두 노드가 같은 그래프에 속하면) 
    			//해당 간선을 선택하지 않는다.
    			if(fromParent == toParent) continue;
     
    			total += cost;
    			parent[toParent] = fromParent; //간선을 연결해 두 노드가 같은 그래프에 속하게 되었으므로 부모 노드를 갱신
    		}
    		return total;
    	}
     
    	//부모노드가 자기자신과 같은 노드를 찾을 때 까지 재귀호출 
    	private int findParent(int node) {
    		if(parent[node] == node) return node;
    		return parent[node] = findParent(parent[node]);
    	}
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int ireland = 5;
        int cost[][] = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}};
        int result = solution.solution(ireland, cost);
        System.out.println(result);
    }
}


//package greedy;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Programmes_섬연결허기 {
//
//	static class Solution {
//		HashMap<int[], Integer> map = new HashMap<>();
//
//		public int solution(int n, int[][] costs) {
//			int answer = 0;
//
//			for (int i = 0; i < costs.length; i++) {
//				map.put(new int[] { costs[i][0], costs[i][1] }, costs[i][2]);
//			}
//
//			// 비용길이가 가장 적은 순서대로 정렬 (value 오름차순)
////	        List<Integer> valueList = new ArrayList<>(map.values());
////	        valueList.sort(Integer :: compareTo);
//
//			// 비용길이가 가장 적은 순서대로 정렬 (value 오름차순)
//			List<Map.Entry<int[], Integer>> entries;
//
//			entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
//
////			// 섬에 방문배열 초기화
////			boolean visited[] = new boolean[n + 1];
////
////			// 비용길이가 작은 순서에 따라 섬의 방문 여부 및 비용 계산
////			for (Map.Entry<int[], Integer> entry : entries) {
////				int[] node = entry.getKey();
////				int depart = node[0];
////				int arrive = node[1];
////
////				if (visited[depart] == false || visited[arrive] == false) {
////					answer += entry.getValue();
////					visited[depart] = true;
////					visited[arrive] = true;
////				}
////			}
//
//			// 섬에 방문배열 초기화
//			int totalLine = n - 1;
//
//			// 비용길이가 작은 순서에 따라 섬의 방문 여부 및 비용 계산
//			for (Map.Entry<int[], Integer> entry : entries) {
//				int[] node = entry.getKey();
//				int depart = node[0];
//				int arrive = node[1];
//
//				if (totalLine > 0) {
//					answer += entry.getValue();
//					totalLine--;
//				}
//			}
//			return answer;
//		}
//	}
//
//	public static void main(String[] args) {
//		Solution solution = new Solution();
//
//		int ireland = 5;
////		int cost[][] = new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
////		int cost[][] = new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 4 }, { 3, 4, 1 } };
//		int cost[][] = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}};
//		int result = solution.solution(ireland, cost);
//		System.out.println(result);
//	}
//}
