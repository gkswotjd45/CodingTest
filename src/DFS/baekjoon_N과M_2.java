package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon_N과M_2 {
	static StringBuilder sb = new StringBuilder();
	static int numberRange, pick;
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		numberRange = Integer.parseInt(st.nextToken());
		pick = Integer.parseInt(st.nextToken());

		arr = new int[pick];
		visited = new boolean[numberRange + 1];

		int depth = 0;

		DFS(1, depth);
		System.out.println(sb);
	}

	private static void DFS(int start, int depth) {

		// 깊이와 뽑아야할 수가 동일한 경우
		if (depth == pick) {
			for (int a : arr) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}

		// 깊이에 따른 숫자를 뽑는 형태.

		for (int i = start; i <= numberRange; i++) {

			if (visited[i] != true) {
				visited[i] = true;
				// 현재 깊이를 index로 하여 해당 위치에 i 값을 저장
				arr[depth] = i;
				DFS(i + 1, depth + 1);
				visited[i] = false;
			}
		}

		return;
	}

}
