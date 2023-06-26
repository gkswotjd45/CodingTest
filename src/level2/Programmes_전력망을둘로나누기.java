package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmes_전력망을둘로나누기 {
	static class Solution {
		//BFS를 위해 각 노드가 갈 수 있는 정점을 그래프 표현
	    static int[][] arr;

	    static int solution(int n, int[][] wires) {
	        int answer = n;
	        // 인덱스가 1부터 시작이므로 해당인덱스에 맞도록 값을 저장.
	        // 1부터 n까지이기 때문에 크기는 [n+1][n+1]입니다.
	        arr = new int[n + 1][n + 1];

	        for (int i = 0; i < wires.length; i++) {
	            arr[wires[i][0]][wires[i][1]] = 1;
	            arr[wires[i][1]][wires[i][0]] = 1;
	        }


	        for (int i = 0; i < wires.length; i++) {
	            arr[wires[i][0]][wires[i][1]] = 0;
	            arr[wires[i][1]][wires[i][0]] = 0;

	            int currentDifference = bfs(n, wires[i][0]);
	            answer = Math.min(answer, currentDifference);

	            arr[wires[i][0]][wires[i][1]] = 1;
	            arr[wires[i][1]][wires[i][0]] = 1;

	            
	        }

	        return answer;
	    }

	    static int bfs(int n, int start) {
	        // 분리될 때, 자기 자신 노드의 값은 기본적으로 1
	        int count = 1;

	        int[] visited = new int[n + 1];

	        Queue<Integer> queue = new LinkedList<>();
	        // 큐에 시작 노드 값 넣기
	        queue.offer(start);

	        while (!queue.isEmpty()) {
	            // 큐에 저장된 값을 가져옴
	            int v = queue.poll();
	            System.out.println("현재 처리중인 노드: " + v);
	            // 시작 노드 방문 처리
	            visited[v] = 1;

	            for (int i = 1; i <= n; i++) {
	                // 방문하지 않았고, 해당 노드가 연결되어 있다면
	                if (visited[i] == 0 && arr[v][i] == 1) {
	                    // 큐에 그 노드를 추가
	                    queue.offer(i);
	                    System.out.println("큐에 추가된 노드: " + i);
	                    // 방문한 노드 개수 증가
	                    count += 1;
	                }
	            }
	            System.out.println("현재까지 방문한 노드의 개수: " + count);
	        }
	        // 방문한 노드의 개수와 나머지 노드의 개수 차이를 절대값으로 반환
	        int result = Math.abs(count - (n - count));
	        System.out.println("방문한 노드의 개수와 나머지 노드의 개수 차이: " + result);
	        return result;
	    }

	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[][] = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};	
	
		System.out.println(solution.solution(9, arr));
	}
}
