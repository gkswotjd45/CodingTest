package level3;

import java.util.Arrays;
import java.util.HashSet;



public class Programees_불량사용자 {
	static class Solution {
		static HashSet<String> set; // 경우의 수를 담기 위한 HashSet
		static boolean[] check; // 방문 배열 
		
		// 정규 표현을 위해 '*'를 '.'로 바꾼다.
		// 정규식 표현에서 '.'은 해당 위치의 모든 문자를 대변한다. 
		public int solution(String[] user_id, String[] banned_id) {
			check = new boolean[user_id.length];
	        set = new HashSet<String>();
			
			for(int i=0; i<banned_id.length;i++) {
				banned_id[i] = banned_id[i].replace('*', '.');
			}
			  back(0,"",banned_id,user_id); // 조합
				
				return set.size();
			}
				
			
//			//user_id [] = [frodo,fradi,crodo,abc123,frodoc]
//			//banned_id[] = [fr*d*,abc1**]
//			int answer = 0;
//			Arrays.stream(banned_id)
//			.map(banned -> banned.replace('*', '.')) // '*'문자를 => '.' 으로 변경
//			.map(banned -> Arrays.stream(user_id) // user_id를 Stream 으로 변환
//			.filter(id -> id.matches(banned)).toArray(String[] ::new)) // 정규표현식에 매칭되는 아이디만 남겨 배열을 구성
//			.toArray(String[][]::new); // 2차원 배열 변환
//			return answer; // 불량 사용자 아이디에 매칭되는 사용자 목록이 담긴 2차원 배열
		
		
		public static void back(int depth, String res, String[] banid, String[] userid) {
			// 불량 유저 ID 개수만큼 조합이 만들어 질때 종료
			// 조합된 아이디 배열에 담고 정렬
			if(depth==banid.length) {
				String[] arr = res.split(" ");
				Arrays.sort(arr);
				
				String str="";
				for(String s:arr) str+=s;//정렬된 id들을 하나의 문자열로 추가
				set.add(str);//중복되는 경우의수는 HashSet로 하나만 남음.
				
				return;
			}
			
			for(int i = 0; i<userid.length; i++) {
				// 유저id 조합
				// 이미 쓴 유저 ID or 불량 ID 중 '.'을 제외하고 유저id랑 다른 부분이 있으면 탐색 안함.
				if(check[i] || !userid[i].matches(banid[depth])) continue;
				check[i] = true;
				back(depth+1, userid[i]+" "+res, banid, userid);
				check[i] =false;
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] bannedId = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution.solution(userId, bannedId));
	}
}

