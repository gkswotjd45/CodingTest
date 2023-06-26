package level2;

import java.util.HashMap;

public class Programmes_의상_map {
	static class Solution {
		
		// 해시를 이용해서 매일 다른 옷 조합하여 나나태는 경우의 수
		// 옷의 조합보다는 조합의 개수에 집중
		// 1. 각 종류별 옷의 개수를 구한 뒤, 각 종류별 옷의 조합에 대한 경우의 수를 구함.
		// 즉, 각 집합이 몇 개의 원소(옷의 종류)를 갖고 있는지 파악 후, 조합할 수 있는 경우의 수를 구함.
		//ex) 안면 2가지 종류, 상의 1가지 종류, 하의 1가지 종류, 겉옷 1가지 종류 
		// 모든 경우의 수 (2*1)+(1*1)+(1*1)+(1*1) - 1 = 24가지 경우의 존재 
		// +1을 한 이유는 oo, ox, xx 총 경우의 수 3가지 나옴
		// -1을 한 이유는 위 4가지 종류 모두 선택하지 않을 경우의 수도 존재함. 
		// key의 개수는 = 조합의 개수
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        HashMap<String,Integer> map = new HashMap<>();
	        
	       for(String [] classfy : clothes) {
	    	   // 옷의 분류 항목을 key로 선택하여. 만약 해당 key가 처음으로 들어오면 초기 값이 1이고, 이후 +1 씩 증가함.
	    	   map.put(classfy[1], map.getOrDefault(classfy[1], 1)+1);
	       }
	       
	       for(String key : map.keySet()) {
	    	   System.out.println(key);
	    	   // 각 옷의 종류에 대한 value 값을 곱하여 누적
	    	   answer *= map.get(key);
	       }
	       
	       // 모두 사용하지 않을 경우도 선택.
//	       answer -= 1;
	       
	      return answer-1;
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String [][] arr = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		int result = solution.solution(arr);
		System.out.println(result);
	}
}
