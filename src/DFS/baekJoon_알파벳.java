package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekJoon_알파벳 {
	static int dX[] = { 0, 0, 1, -1 };
	static int dY[] = { 1, -1, 0, 0 };
	static int R;
	static int C;
	static char table[][];
	static int result;
	static boolean[][] visited;
	static List<Character> charCheck;

	public static void alphabet() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 테이블 세로  
		R = Integer.parseInt(st.nextToken());

		// 테이블 가로
		C = Integer.parseInt(st.nextToken());

		table = new char[R][C];
		visited = new boolean[R][C];

		// 글자 확인 용 List 배열
		charCheck = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				table[i][j] = str.charAt(j);

			}
		}

		// 깊이 우선 탐색 [백 트래킹으로 진행] 
		DFS(0, 0, 1);
		System.out.println(result);
	}

	private static void DFS(int x, int y, int depth) {
		visited[x][y] = true;
		charCheck.add(table[x][y]);

		for (int i = 0; i < 4; i++) {

			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX < R && nX >= 0 && nY < C && nY >= 0 && !visited[nX][nY] && !charCheck.contains(table[nX][nY])) {
				DFS(nX, nY, depth + 1);
			}
		}

		result = Math.max(result, depth);
		visited[x][y] = false;
		charCheck.remove((Character) table[x][y]);
	}

	public static void main(String[] args) throws IOException {
		alphabet();
	}
}
