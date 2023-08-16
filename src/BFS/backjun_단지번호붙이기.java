package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjun_단지번호붙이기 {
	static StringBuilder sb;
	static int apt[][];
	static boolean visited[][];
	static int size;
	static int dx[] = { 0, 0, 1, -1 }; // x축에 대한 상하좌우
	static int dy[] = { 1, -1, 0, 0 }; // y축에 대한 상하좌우
	static int count; // 단지당 가구수

	public static void apt() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정사각형 사이즈
		size = Integer.parseInt(br.readLine());

		apt = new int[size][size];
		visited = new boolean[size][size];

		// 아파트 값 초기화
		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				apt[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		ArrayList<Integer> arr = new ArrayList<>();

		// 총 단지 수
		int result = 0;

		
//		// DFS 방식
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				count = 0;
//				if (apt[i][j] == 1) {
//					DFS(i, j);
//					arr.add(count);
//					result++;
//				}
//			}
//		}

		// BFS 방식
		for(int i=0;i<size; i++) {
			for(int j = 0; j<size; j++) {
				count = 0;
				
				if(apt[i][j] == 1) {
					BFS(i,j);
					arr.add(count);
					result++;
				}
			}
		}
		
		
		Collections.sort(arr);
		sb = new StringBuilder();
		sb.append(result).append("\n"); // 총 단지 수

		
		// 단지 당 가구 수 출력
		for (int i : arr) {
			System.out.println(i);
		}

//		for (int i = 0; i < size; i++) {
//
//			for (int j = 0; j < size; j++) {
//				// 집이 있으면서 방문하지 않은 곳
//				if (apt[i][j] == 1 && !visited[i][j]) {
//					DFS(i, j); // 연결되어 있는 단지 탐색
//					count++;// 단지 수 추가
//				}
//			}
//		}
//		sb = new StringBuilder();
//		sb.append(count-1).append("\n");// 총 단지수
//
//		// 단지 당 가구 수
//		int[] reselt = new int[count];
//
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				if (apt[i][j] != 0) {
//					reselt[apt[i][j]]++;
//				}
//			}
//		}

//		// 가구수를 오름차순으로 정령
//		Arrays.sort(reselt);
//		for (int i = 1; i < reselt.length; i++) {
//			sb.append(reselt[i]).append("\n");
//		}

	}

	private static void DFS(int x, int y) {
		apt[x][y] = 0; // 방문한집 표시
		count += 1;

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			// 베열의 범위를 벗어나지 않는 범위 내에서 탐색
			if (nX >= 0 && nX < size && nY >= 0 && nY < size) {
				if (apt[nX][nY] == 1 && !visited[nX][nY]) {
					DFS(nX, nY); // 연결 되어있는 단지 탐색
				}
			}
		}

	}

	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });
		apt[x][y] = 0;

		while (!queue.isEmpty()) {
			count += 1;

			int now[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = now[0] + dx[i];
				int nY = now[1] + dy[i];

				if (nX >= 0 && nX < size && nY >= 0 && nY < size && apt[nX][nY] == 1) {
					apt[nX][nY] = 0;
					queue.offer(new int[] { nX, nY });
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		apt();
		System.out.println(sb);
	}
}
