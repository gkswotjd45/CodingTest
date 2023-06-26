package java_codingTest_연습;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Programmes_두개뽑아서더하기 {
	static class Solution {
//	    public int[] solution(int[] numbers) {
//	        int[] answer = {};
//	        int count =0;
//	        HashSet<Integer> set = new HashSet<Integer>();
//	        
//	        for(int i=0; i<numbers.length; i++) {
//	        	for(int j=1; j<numbers.length; j++) {
//	        		if(!(i == j)){
//	        		answer[count] = numbers[i] + numbers[j];
//	        		count++;
//	        		}
//	        	}
//	        }
//	        for(int a : answer) {
//	        	set.add(a); //set에 특징 중복된 값을 저장할 수 없음.
//	        }
//	
//	        return set.stream().sorted().mapToInt(Integer::intValue).toArray(); 
//	        //set을 int[] 변환
//	        
//	    }
		public int[] solution(int[] numbers) {
		    ArrayList<Integer> list = new ArrayList<>(); // arraylist을 이용하여 값을 동적으로 추가
		    HashSet<Integer> set = new HashSet<>();  // 값의 중복값을 없애기 위해 사용.
		    
		    for(int i = 0; i < numbers.length; i++) {
		        for(int j = i + 1; j < numbers.length; j++) {
		            int sum = numbers[i] + numbers[j];
		            if(!set.contains(sum)) {
		                set.add(sum);
		                list.add(sum);
		            }
		        }
		    }
		    
		    Collections.sort(list);
		    int[] answer = new int[list.size()];
		    for(int i = 0; i < list.size(); i++) {
		        answer[i] = list.get(i);
		    }
		    
		    return answer;
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] array = {5,0,2,7};
		int [] result = solution.solution(array);
		
		for(int a : result) {
			System.out.println(a);
		}
	}
}
