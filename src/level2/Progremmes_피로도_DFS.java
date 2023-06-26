package level2;

public class Progremmes_피로도_DFS {
	
	static class Solution {
		// 이 문제는 던전을 갈 수 있는 모든 경우의 수를 구하여 진행.
		// 한 던전은 DFS의 한 노드와 같음
		// 즉 dungeons를 선회하면서 -> 이미 방문한 던전 인지를 확인함. 
		// boolean type의 visited를 이용하여 만약 방문하였다면, 다음 노드로 넘어감
		// 각 던전의 필요 hp와 현재 hp를 비교하여 던전을 탐험할 수 있는지 파악한다.
		
		// 이 문제는 던전의 배열을 변화하지 않고, 재귀함수의 파라미터를 줄일 수 있다.
		int answer = 0;
		boolean visited [];
		
		public int solution(int k, int[][] dungeons) {
			// 던전의 개수만큼 방문 여부 boolean 배열로 나타	냄
	        visited= new boolean [dungeons.length];
	        // dfs 초기값으로 깊이는 0, 체력 k, 던전 목록등을 선언
	        dfs(0,k,dungeons);
	        
	        return answer;
	    }
		
		public void dfs(int depth,int k, int[][] dungeons) {
			//던전의 개수 만큼 반복
			  for (int i = 0; i < dungeons.length; i++) {
		            if (!visited[i] && dungeons[i][0] <= k) {
		            	visited[i] = true;
		                dfs(depth + 1, k - dungeons[i][1], dungeons);
		                visited[i] = false;
		            }
		        }
			answer = Math.max(answer,depth);
			
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[][]= {{80,20},{50,40},{30,10}};
		int result = solution.solution(80, arr);
		System.out.println(result);
	}

}
