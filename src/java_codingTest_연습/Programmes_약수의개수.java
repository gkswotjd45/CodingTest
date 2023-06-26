package java_codingTest_연습;

public class Programmes_약수의개수 {
	static class Solution {
	    public int solution(int left, int right) {
	        int answer = 0;
	        int count = 1; // 약수의 개수
	        int arr[] = new int[(right - left)+1];
	        for(int i = left; i<=right; i++) {
	        	for(int j = 2; j<=left; j++) {
	        		if(left % j == 0) {
	        			count++;
	        		}
	        	}
	        	arr[i] = count;
	        	count = 1;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		
	}
}
