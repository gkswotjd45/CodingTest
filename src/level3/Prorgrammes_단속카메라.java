package level3;

import java.util.Arrays;

public class Prorgrammes_단속카메라 {
	static class Solution {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        
	        int camera = Integer.MIN_VALUE;
	        int[][] arr = routes.clone();
	        // arr = [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
	        
	        // 2차원 배열 정렬 // 2차원의 배열에서 2번째 항목값을 오름차순으로 정렬
	        Arrays.sort(arr,(o1,o2) -> {	
	        	return o1[1]-o2[1];
	        });
//	        // 단속카메라 설치
//	        for(int i = 0; i< routes.length ; i++) {
//	        	if(camera<routes[i][0]) {
//	        		camera = routes[i][1];
//	        		answer++;
//	        	}
//	        }
        
//	        // 단속카메라 설치
//	        for(int i = 0; i<routes.length; i++) {
//	        	
//	        	if(i == routes.length -1) {
//	        		answer++;
//	        	}
//	        	else if(arr[i][1]<0 && (arr[i][1]<arr[i+1][0])) {
//	        		answer++;
//	        	}
//	        	else if(arr[i][1]<=arr[i+1][0]) {
//	        		answer++;
//	        	}
//	        }
	        
	        for(int [] route : routes) {
	        	
	        	if(camera < route[0]) {
	        		// 현재 카메라의 위치가 route 시작 지점보다 작으면
	        		// 새로운 카메라을 route의 종료 지점에 설치함.
	        		camera = route[1];
	        		answer++;
	        	}
	        }
	        
	        
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] arr = {{-9,-5}, {-4,-2}, {-1,4}, {1,5},{-3,6},{2,10},{7,12}};
		System.out.println(solution.solution(arr));
	}
}
