package level2;

import java.util.Arrays;

public class Programmes_최솟값만들기 {
	static class  Solution{
	 public int solution(int []A, int []B)
    {
		// A = [1, 4, 2] , B = [5, 4, 4]
        int answer = 0;
        // 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i<A.length; i++) {
        	for(int j = A.length-1-i; j>=0; j--) {
        		answer += A[i]*B[j];
        		break;
        	}
        }
        
    
        return answer;
    	}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1, 4, 2};
		int[] arr1 = {5, 4, 4};
		int result = solution.solution(arr, arr1);
		System.out.println(result);
	}
}
