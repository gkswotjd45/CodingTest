package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Programmes_추억점수 {

	static class Solution {
		 public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int[photo.length]; // 사진의 행의 길이 만큼 값이 나옴.
			
			// name = {"may", "kein", "kain", "radi"};
			// yearing = {5, 10, 1, 3}
			
			
			Map<String, Integer> map = new HashMap<>();
			
			// map을 이용해 key에 이름, value에 저장할 수치 저장.
			for(int i = 0; i<name.length; i++) {
				map.put(name[i], yearning[i]);
			}
			// map = {{may,5},{kein,10}...};
			
			// photo = [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
			

			
			// 사진의 값들을 이중 for문 수행하기
			for(int i = 0; i<photo.length; i++) {
				for(int j = 0; j<photo[i].length; j++) {
					Set<String> names = map.keySet();
					Iterator<String> iter = names.iterator();
					while(iter.hasNext()) {
						String nick = iter.next(); 
						if(nick.equals(photo[i][j])) {
							answer[i] += map.get(nick); 
							break;
						}
					}
				}
			}
			

			
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String [] name = {"may", "kein", "kain", "radi"};
		int [] yearing = {5, 10, 1, 3};
		String[][] photo =  {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};
		int arr [] =solution.solution(name, yearing, photo);
		for(int i =0 ; i<3; i++) {
			System.out.println(arr[i]);
		}
	}
}
