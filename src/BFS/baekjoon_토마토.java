package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_토마토 {
	static StringBuilder sb;
	static int dX[] = { 0, 0, 1, -1 };
	static int dY[] = { 1, -1, 0, 0 };
	static int box[][];
	static boolean visited[][];
	static int day;
	static int m;
	static int n;
	static Queue<int[]> queue = new ArrayDeque<>(100);

	static void tomato() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

// 상자 가로크기
		m = Integer.parseInt(st.nextToken());
// 상자 세로크기
		n = Integer.parseInt(st.nextToken());

		box = new int[n][m];
		visited = new boolean[n][m];

		// 박스 상태 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				// 박스안에 토마토가 없으면 이미 방문처리함.
				if (box[i][j] == -1) {
					visited[i][j] = true;
				}

				// 익은 토마토 위치
				if (box[i][j] == 1) {
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		// 최소 소요일
		day = 0;
		BFS(queue);

		// 모든 토마토가 익었는지 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					day = -1;
					break;
				}
			}
			if (day == -1) {
				break;
			}
		}

		sb = new StringBuilder();
		sb.append(day);
	}

	private static void BFS(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int cur[] = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nX = cur[0] + dX[i];
					int nY = cur[1] + dY[i];

					if (nX < n && nX >= 0 && nY < m && nY >= 0 && !visited[nX][nY] && box[nX][nY] == 0) {
						visited[nX][nY] = true;
						box[nX][nY] = 1; // 토마토를 익힘
						queue.offer(new int[] { nX, nY });
					}
				}
			}
			if (!queue.isEmpty()) {
				day++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		tomato();
		System.out.println(sb);
	}
}
