package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon_적록색약 {
	static StringBuilder sb;
	static int size;
	static char[][] arr;
	static boolean[][] vistied;
	static int[] dX = { 0, 0, 1, -1 };
	static int[] dY = { 1, -1, 0, 0 };

	public static void redGreenColorWeakness() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());

		// 사이즈 초기화
		arr = new char[size][size];
		vistied = new boolean[size][size];

		// 그래프 초기화
		for (int i = 0; i < arr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

//		 RGB 그룹 개수
		int result = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!vistied[i][j]) {
					DFS(i, j, arr[i][j]);
					result++;
				}
			}
		}

		// 적녹색약 분들이 구분하는 색상
		int quailfy = 0;
		vistied = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!vistied[i][j]) {
					DFS_Qualify(i, j, arr[i][j]);
					quailfy++;
				}
			}
		}

		sb = new StringBuilder();
		sb.append(result).append(" ");
		sb.append(quailfy);
	}

	private static void DFS_Qualify(int x, int y, char color) {
		vistied[x][y] = true;
		char newColor = color;
		if (newColor == 'R' || newColor == 'G') {
			newColor = 'P';
		}

		// 해당 좌표에 대한 상하좌우 접근
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			// 배열의 범위를 벗어나지 않는 범위 내에서 탐색
			if (nX >= 0 && nX < size && nY >= 0 && nY < size) {
				char nextColor = arr[nX][nY];
				if (nextColor == 'R' || nextColor == 'G') {
					nextColor = 'P';
				}
				if (!vistied[nX][nY] && nextColor == newColor) {
					DFS_Qualify(nX, nY, color);
				}
			}
		}
	}

	private static void DFS(int x, int y, char color) {
		vistied[x][y] = true;

		// 해당 좌표에 대한 상하좌우 접근
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			// 베열의 범위를 벗어나지 않는 범위 내에서 탐색
			if (nX >= 0 && nX < size && nY >= 0 && nY < size) {
				if (!vistied[nX][nY] && arr[nX][nY] == color) {
					DFS(nX, nY, color);
				}
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		redGreenColorWeakness();
		System.out.println(sb);
	}

}
