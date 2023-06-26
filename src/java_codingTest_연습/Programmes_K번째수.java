package java_codingTest_연습;

import java.util.Arrays;

public class Programmes_K번째수 {
	
	 public static int[] removeElement(int[] arr, int item) {
	        return Arrays.stream(arr)
	                .filter(i -> i != item) // i값이 0값이면 배열에 나타냄.
	                .toArray();
	  }
	 
	static public class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	    	int[] answer = new int[commands.length]; //[[2,5,3]..] 2차원 배열에 접근하기 위해. // 각 행의 값을 담은 answer
	    	
	    	for(int i = 0; i< answer.length; i++)
	    	{
	    		int[] command = commands[i];
	    		int from = command[0] -1;  //[[2,5,3]..]  시작위치 = 배열을 항상 0부터 시작이므로 -1 해야 함
	    		int to = command[1]; // ~까지 위치 =>     i < to = to 이전 까지만 진행하므로
	    		int k = command[2] - 1; // 정렬 후 특정 위치 지정.
	    		
	    		int[] sub =Arrays.copyOfRange(array, from, to); // Array의 특정구간 잘라내기
	    		Arrays.sort(sub);
	    		answer[i] = sub[k];
	    	}
	    	
	    	return answer;
	    	
	    	
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[] = {1,5,2,6,3,7,4};
		int commend[][] = {{2,5,3}}; 
		int result[] = solution.solution(arr,commend);
		for(int i = 0; i< result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
