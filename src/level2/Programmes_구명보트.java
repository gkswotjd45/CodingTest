package level2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Programmes_구명보트 {
	
 static class Solution {
	 
	 // 최소한의 홋수로 옮기기 위해 가장 큰 몸무게 사람과 + 기징 직은 몸무게가 작은 사람의 조합
	 // 이어야 함 
	 // 배열은 먼저 시킨다음
	 // 2. min을 0으로 최소값의 위치 역할
	 // 3. 반복문을 돔
	 // 4. 초기값 max 는 people 배열의 크기 -1
	 // max는 최대값 위치의 역할
	 // 5. min <= max 일때 반복 
	 // 최솟값의 위치가 최대값의 위치보다 큰 경우 반복 종료
	 // 반복문 people의 min 위치에 있는 값과 + max위치에 있는 값이 limit보다 
	 // 작거나 같으면 min++.
	 // answer ++; => 위 조건문을 걸리지 많으면 수행
	 
	 
	  public int solution(int[] people, int limit) {
		  int answer = 0;

		    Arrays.sort(people);

		   int min = 0;
		   
 		   for(int max = people.length -1; min<=max; max--) {
			   if(people[min] + people[max]<=limit) min++; // if문 조건에 걸리면 최소 형태임 
			   answer++;
		   }
		   
		   return answer;
		   
	  }
	 
//	    public int solution(int[] people, int limit) {
//	        int answer = 0;
//	        
	        
//	        Arrays.sort(people); // 정수형 오름차순으로 정렬 
//	        // 50, 50, 70, 80, 
//	        
//	        for(int i = people.length - 1; i>=0 ; i--) {
//	        	for(int j = i-1; j>=i ; j--) {
//	        		if (people[i] + people[j]<=limit) {
//	        			
//	        		} 
//	        		
//	        	}
//	        }
//	        
//	        
//	        return answer;
//	    }
	}
 
 	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {70, 50, 80, 50};
		int result = solution.solution(arr,100);
		System.out.println(result);
	}
}
