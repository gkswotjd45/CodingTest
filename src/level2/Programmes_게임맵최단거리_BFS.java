package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmes_게임맵최단거리_BFS {
	// 1. 재귀적인 특징을 가지거나, 백트리킹을 이용해야 하는 경우 DFS - 깊이 우선 탐색
	// ex) 순열 조합
	// 2. 깊이를 이용한 문제를 풀어야 하는 경우 BFS 
	// ex)최단 거리 구하기
	
	// why? 최단 경로를 찾는 문제에서는 도착점에 도달한 순간 종료되는 BFS를 이용한다.
	// DFS는 모든 경로를 탐색하기 때문에 적합하지 않다.
	
	// 주어지는 파라미터에 전역변수로 넘긴다. (코득 간결해짐)
	// 이동방향이 정햐진 문제라면 전역상수로 이동방향을 미리 정의한다.
	// BFS에흔 현재 위치를 파라미터로 넘겨 받는다.
	
	static class Solution {

		// 상하좌우 이동시 x,y 좌표 위치지정.
		int[] dy= {0,0,1,-1}; // y좌표 
		int[] dx= {1,-1,0,0}; // x좌표
		
		
		void bfs(int[][] maps, int[][] visited){
			Queue<int[] > q = new LinkedList<>(); // queue로 BFS 구현하기
			q.add(new int[] {0,0}); // queue에 시작 정점 추가
			visited[0][0]=1; // 현재 초기점. 
			
			while(!q.isEmpty()) { // 더 나아갈 정점이 없을때 까지 반복
				
				int[] current = q.poll(); // 정점 하나 꺼내기
				int x = current[0];
				int y = current[1];
				
				for(int i=0; i<4; i++) {
					int nX = x+dx[i]; // 상하좌우로 나갈 수 있는 좌표
					int nY = y+dy[i]; // 상하좌우로 나갈 수 있는 좌표
					
					// 좌표가 maps에서 벗어날 경우 다음 반복으로 넘어감
					// x값이 0보다 작거나,y가 0보다 작거나, x,y 값이 배열의 크기와 초과되었을 경우
					if(nX<0 || nX>maps.length-1|| nY<0 || nY> maps[0].length -1) {
						continue;
					}
					
					// 아직방문하지 않았고, 벽이 아닐 경우
					if(visited[nX][nY] == 0 && maps[nX][nY] == 1) {
						visited[nX][nY] = visited[x][y] + 1;
						q.add(new int[] {nX,nY});
					}
				}
			}
		}
		int solution(int[][] maps) {
			
			int answer = 0;
			int[][] visited = new int[maps.length][maps[0].length];
			
			bfs(maps,visited);
			answer = visited[maps.length-1][maps[0].length - 1]; // 목표지점 도달
		
			// 상대 팀 진영에 도달하지 못한 경우
			if(answer == 0) {
				answer = -1;
				
			}
			return answer;
		}
		
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution.solution(maps);
		System.out.println(solution.solution(maps));
	}
    
}
