package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmes_네트워크_BFS_DFS {

	// 그냥 간선으로 이동할 수 있는 노드들을 1로 계산하고, 따로 떨어져 있는 노드들로 1로 계산하여 모두 다하면 되는 문제
	
	static class Solution {
	    static boolean[] visited;
	    static Queue<Integer> que = new LinkedList<>();

	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        visited = new boolean[n];
//
//	        for (int i = 0; i < n; i++) {
//	            if (visited[i] == false) {
//	                System.out.println("BFS 탐색 시작 컴퓨터 " + i);
//	                BFS(i, computers, n);
//	                answer++;
//	                System.out.println("BFS으로 탐색완료 된 컴퓨터 " + i + ", 현재까지 네트워크의 수:  " + answer);
//	            }
//	        }
	        
	        for(int i=0; i<n; i++) {
        		if(visited[i] == false) {
        			 System.out.println("DFS 탐색 시작 컴퓨터 " + i);
        			answer++;
        			DFS(i, computers, n);
        		}
        }

	        return answer;
	    }

	    // 너비 우선 탐색  //탐색할 컴퓨터, 연결되어 있는 컴퓨터 배열정보, 네트워크 내의 컴퓨터 총수
	    static void BFS(int i, int[][] computers, int n) {
	        que.offer(i); // 탐색을 시작할 노드를 큐에 추가
	        visited[i] = true; // 탐색할 컴퓨터에 방문 여부 추가

	        // 아직 방문해야 하는 컴퓨터가 있으면 계속 탐색
	        while (!que.isEmpty()) {
	            int value = que.poll(); // 현재 방문하는 컴퓨터 값 가져오기
	            System.out.println("해당" + value + "번 컴퓨터 방문함 ");

	            for (int j = 0; j < n; j++) {
	            	// j번 노드가 아직 방문되지 않았고, value번 컴퓨터와 j번 컴퓨터가 연결되어 있다면,
	                if (visited[j] == false && computers[value][j] == 1) {
	                    visited[j] = true;
	                    que.offer(j); // j번 노드를 큐에 추가하여 나중에 방문할 수 있게 함
	                    System.out.println("컴퓨터 " + j + "번을 큐에 추가했습니다.");
	                }
	            }
	        }
	    }
	    
	    //깊이 우선 탐색
	    static void DFS(int i, int computers[][], int n) {
			visited[i] = true;	
			System.out.println(i + "번 컴퓨터 방문함");
			 
			for(int j=0; j<n; j++) {
				if(visited[j] == false && computers[i][j] == 1) {
				    System.out.println(i + "번 컴퓨터에서 " + j + "번 컴퓨터로 이동");
					DFS(j, computers, n);
				}
			}

		} // End of DFS
	}


	public static void main(String[] args) {
	    Solution solution = new Solution();
	    int com = 3;
	    int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	    System.out.println("네트워크로 연결된 컴퓨터: " + solution.solution(com, computers));
	}
}
