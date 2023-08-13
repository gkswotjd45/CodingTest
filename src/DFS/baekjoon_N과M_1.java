package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_N과M_1 {
	static StringBuilder sb;
	static boolean[] visited;
	// 깊이 탐색에 따른 값 저장 공간
	static int arr [];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		// 숫자 범위
		int numberRange = Integer.parseInt(st.nextToken());
	
		// 뽑아야 하는 숫자
		int pick = Integer.parseInt(st.nextToken());
		
		// 방문 여부 처리
		visited = new boolean[numberRange+1];
		arr = new int[pick];
		
		int depth = 0;
		DFS(numberRange, pick,depth);
		

	}
	private static void DFS(int numberRange, int pick, int depth) {
		

		// 뽑으려는 숫자와 현재 탐색한 깊이가 동일한 경우
		if(depth == pick) {
			for (int a : arr) {
				System.out.print(a+" ");
			}
			System.out.println();
			return ;
		}
		
		// 깊이 탐색을 통한 숫자 선택하기
		for(int i =1 ; i<=numberRange; i++) {
			// 현재 해당 값을 방문하지 않은 경우
			if(visited[i] == false) {
				visited[i] = true;
				arr[depth] = i;
				DFS(numberRange,pick,depth+1);
				
				visited[i] =false;
			}
		}
		
		return;
		
	}
}
