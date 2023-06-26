package level1;

public class Programmes_평균구하기 {
	static class Solution {
	    public double solution(int[] arr) {
	        double answer = 0;
	        double count = 0;
	        for(int i= 0; i<arr.length; i++) {
	        	answer += arr[i];
	        	count++;
	  
	        	
	        }
	        answer/=count;
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr =  {1,2,3,4};
		System.out.println(solution.solution(arr));
		
	}
}
