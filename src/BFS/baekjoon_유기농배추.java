package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;

public class baekjoon_유기농배추 {
	static StringBuilder sb;

	static int[][] field;
	static boolean[][] visted;
	static int[] dX = new int[] { 0, 0, 1, -1 }; // x좌표에 대한 상하좌우 처리
	static int[] dY = new int[] { 1, -1, 0, 0 }; // y좌표에 대한 상하좌우 처리
	static int lineSize;
	static int rowSize;

	public static void napa_Cabbage() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		sb = new StringBuilder();

		// 테스트 케이스마다 수행
		for (int t = 0; t < test; t++) {

			st = new StringTokenizer(br.readLine());
			lineSize = Integer.parseInt(st.nextToken()); // 행의 길이
			rowSize = Integer.parseInt(st.nextToken()); // 열의 길이
			int totalCabbage = Integer.parseInt(st.nextToken()); // 총 배추의 심은 개수

			// 밭 크기 초기화
			field = new int[lineSize][rowSize];

			// 배추 위치 초기화
			for (int i = 0; i < totalCabbage; i++) {
				st = new StringTokenizer(br.readLine());
				int line = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				field[line][row] = 1;
			}

			// 총 필요한 지렁이의 수
			int result = 0;

			for (int i = 0; i < lineSize; i++) {
				for (int j = 0; j < rowSize; j++) {
					// 밭에 배추가 있다면
					if (field[i][j] == 1) {
//						BFS(i, j);
						DFS(i, j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
	}

	private static void DFS(int x, int y) {
		field[x][y] = 0; // 방문처리

		for (int i = 0; i < 4; i++) {
			// 인접한 밭의 좌표
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX < lineSize && nX >= 0 && nY < rowSize && nY >= 0 && field[nX][nY] == 1) {
				field[nX][nY] = 0;
				DFS(nX,nY);
			}

		}

	}

	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 현재 방문한 밭 좌표 넣기
		queue.add(new int[] { x, y });

		field[x][y] = 0; // 방문 처리

		// 큐에 값이 비어있지 않을 경우에는
		while (!queue.isEmpty()) {
			// 현 좌표
			int now[] = queue.poll();
			// 현 좌표에 대한 방문할 수 있는 nX와 nY 방문 확인
			for (int i = 0; i < 4; i++) {
				int nX = now[0] + dX[i];
				int nY = now[1] + dY[i];
				// 밭의 사이즈를 초과하지 않고, 인접한 밭에 배추가 있을 경우
				if (nX < lineSize && nX >= 0 && nY < rowSize && nY >= 0 && field[nX][nY] == 1) {
					field[nX][nY] = 0;
					queue.offer(new int[] { nX, nY });
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		napa_Cabbage();
		System.out.println(sb);
	}
}
