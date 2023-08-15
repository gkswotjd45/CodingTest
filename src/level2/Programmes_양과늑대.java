package level2;

public class Programmes_양과늑대 {
	static class Solution {
		// 방문할 수 있는 양의 쵀대 수
		int answer = 0;
		// 각 노드상태 확인 배열
		boolean[] checked;

		public int solution(int[] info, int[][] edges) {
			checked = new boolean[(int) Math.pow(2, info.length)];
			dfs(0, new boolean[info.length], 0, 0, info, edges, 1);
			return answer;
		}

		private void dfs(int idx, boolean[] visited, int sheep, int wolf, int[] info, int[][] edges, int state) {
			visited[idx] = true;
			checked[state] = true;

			if (info[idx] == 0) {
				sheep++;
				answer = Math.max(sheep, answer);
			} else {
				wolf++;
			}

			if (sheep <= wolf) {
				return;
			}

			for (int[] edge : edges) {
				if (visited[edge[0]] && !visited[edge[1]] && !checked[state | (1 << edge[1])]) {
					boolean[] newVisited = visited.clone();
					dfs(edge[1], newVisited, sheep, wolf, info, edges, state | (1 << edge[1]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int info[] = new int[] { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int edge[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 },
				{ 6, 5 }, { 4, 6 }, { 8, 9 } };
		int result = solution.solution(info, edge);
		System.out.println(result);
	}

}
