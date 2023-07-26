package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjun_미로탐색 {
	static StringBuilder sb;

	static int dx [] = {0,0,1,-1}; // 상하좌우
	static int dy [] = {1,-1,0,0}; // 상하좌우
	public static void miro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		
		int destinationRow = Integer.parseInt(st.nextToken());
		int destinationCol = Integer.parseInt(st.nextToken());
		int miro [][];
		int visited [][];
		
		miro = new int [destinationRow][destinationCol];
		visited = new int [destinationRow][destinationCol];
		
		// 미로 배열 값 저장.
		for(int i = 0; i<destinationRow; i++) {
			String row = br.readLine();
			for (int j = 0; j<destinationCol; j++) {
				miro[i][j] = Character.getNumericValue(row.charAt(j));
			}
		}	
		
		BFS(miro, visited);
		
		sb = new StringBuilder();
		sb.append(visited[destinationRow-1][destinationCol-1]).append("\n");
	}
	static void BFS(int[][] maps, int [][] visited) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int [] {0,0});
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			int [] current = queue.poll();
			int x = current[0]; // 현재 x축 좌표
			int y = current[1]; // 현재 y축 좌표
			
			for(int i = 0; i<4; i++) {
				int nX = x+dx[i]; //열의 수 // 가로 횡
				int nY = y+dy[i]; // 행의 수 => 세로 열 세기
				
				// 임의 좌표가 해당 범위을 초과했을 경우
				if(nX<0 || nX>maps.length-1 || nY<0 || nY>maps[0].length -1) {
					continue;
				}
				
				// 아직 방문하지 았았고, 벽이 아닐 경우에 탐색
				if(visited[nX][nY] == 0 && maps[nX][nY] != 0) {
					queue.add(new int[] {nX,nY});
					visited[nX][nY] = visited[x][y] + 1;
				}
							
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		miro();
		System.out.println(sb);
	}
}
