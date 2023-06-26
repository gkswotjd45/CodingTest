package level2;

public class Programmes_정사각형크기 {
	static class Solution {
		public int solution(int[][] board) {
			
			// board의 행과 열 길이를 따로 뽑아 둡니다.
			// 그리고 과 열의 길이 중 하나라도 2보다 작으면 가로 세로 길이가 1보다 더 크게
			// 만들어질 수 있는 정사각형은 없으므로 1을 반환
			
			// 그렇지 않을 경우, 
	        // 가장 위쪽 행과 가장 왼쪽 열만을 제외한 다른 요소들을 반목문을 돌면서 해당 요소가 
		    // 1일 경우에만 해당 요소의 왼쪽, 위쪽, 왼쪽 위 대각선 방향의 숫자들 중 장 작은 수에
			// 1을 더한 수를 해당 요소의 값으로 변경합니다. 이렇게 진행하게 되면 각 요소들이 가자는
			// 값은 해당 요소 자리를 가장 오른쪽 아래에 두고 형성할 수 있는 정사각형의 최대 길이를 가지게 됩니
			
			int answer = 0;
			int max = 0;
			int min1 = 0;

			for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board[0].length; j++) {
					// 사각형의 맨끝에서 누적해서 저장
					if (board[i - 1][j - 1] >= 1 && board[i - 1][j] >= 1 && board[i][j - 1] >= 1 && board[i][j] >= 1) {
						min1 = Math.min(board[i - 1][j - 1] , board[i - 1][j]);
						
						board[i][j] = Math.min(min1,board[i][j - 1]) + 1;
						if (max <= board[i][j]) {
							max = board[i][j]; // 최대값을 가져와서 각 길이 곱을 수행
						}
					}
				}
			}
			
			answer = max * max;
			return answer;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] arr = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int result = solution.solution(arr);
		System.out.println(result);

	}
}