package java_codingTest_연습;

import java.util.HashMap;

public class Programmes_폰켓몬_hashMap {
	static class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        HashMap<Integer, Integer> poket = new HashMap<>();
	        // hashMap으로 중복값 없이 넣기
	        for(int i= 0; i<nums.length; i++) {
	        	poket.put(nums[i],poket.getOrDefault(nums[i], 0) +1);
	        }
	        
	        int max = nums.length /2; // 뽑을 수 있는 최대값
	        int size = poket.size(); // 현재 포켓몬 종류
	        
	        // 뽑을 수 있는 항목 > 현재 포켓몬 종류 보다 많을 경우 = 현재 포켓몬 종류
	        // 뽑을 수 있는 항목 < 현재 포켓몬 경우 => 최대로 뽑을 수 있는 개수
	        return max > size ? size : max; 
	        
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[] = {3,1,2,3};
		int arr1[] = {3,3,3,3,3,3};
		int result = solution.solution(arr1);
		System.out.println(result);
	}
}
