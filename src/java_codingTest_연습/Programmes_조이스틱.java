package java_codingTest_연습;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Programmes_조이스틱 {
	static class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        
	        // name의 길이만큼 AAA로 초기화
	        int stringlength = name.length();
	        String keyword = "";
	        for(int i=0; i<stringlength; i++) {
	        	keyword += 'A' + "";
	        }
	        
	        int index; // 다음 값들들을 확인할 때 사용.
	        
	        // 조이스틱의 상, 하 조작으로 원하는 알파벳 조작하기
	        // 조이스틱을 위로 조작해 알파벳을 찾는경우 '알파멧2' - '알파벳1'
	        // 처음 'A'에서 아래를 조작해 찾는 경우는 26(알파벳 총개수) - ('알파벳2'-'알파벳1')
	        // ex) 'A' 'C'의 경우, 'C'-'A' 위로 2번 조작 O
	        // ex) 'A' 'Y'의 경우. 'Y'-'A' = 24 보다, 아래로 두번 조작하는 값이 더 적음
	        // => Math.min(알파벳2-알페벳1, 26-(알파벳2-앞파벳1))로 최소값을 구하여 answer++;
	        
	        
	        // 조이스틱의 좌,우 조작으로 커서의 위치 조작하기
	        // 커서의 위치가 바뀌게 되는 총 경우는 3가지
	        // 1. 처음부터 쭉 오른쪽으로 가는 경우 => name.length()-1;
	        // 2. 오른쪽으로 갔다가 다시 리턴하여 왼쪽으로 가는 경우 => ex)BBAAAYYY 문자열이 있을때 BB로 이동후 다시 되돌아가 YYY를 완성
	        // 3. 왼쪽으로 갔다가 다시 리턴하여 오른쪽으로 가는 경우 => ex)CCCAAAAAAY 경우 먼저 왼쪽으로 움직여 Y를  조정후 다시 오른쪽으로 돌아가 CCC를 완성
	        
	        // name을 0부터 length()-1 까지 알파벳을 검사 -> 각 알파벳 별로 상하로 조작을 수행
	        // 만약 내 다음 알파벳이 'A'라면 'A'가 끝나는 지점ㄷ을 구함
	        // index==0 인 상태를 기준으로 (커서가 처음 위치하는 부분) 좌우조적 2, 3번 항목 경우 중 최솟값을 비교.
	        
	        // 문자열 'ZYXAAAAAB' 일 때
	        // 현 내위치는 X 이며 index :2 , 'A'가 끝나는 지점 index = 8
	        // 1안 index를 0에서 'X가 있는 2로 이동 후. 다시 0으로 돌아가 왼쪽으로 1칸 더 움직여 B를 교체
	        // => ZYXYZB 으로 이동
	        // (i*2) + (name.length()-연속된 A가 끝나는 지점) => (2*2)+ (9-8)
	        // 2안 index를 0에서 왼쪽으로 움직였다가 다시 0으로 돌아온 후, 오른쪽으로 움직인경우 
	        // => ZBZYX 순으로 이동
	        // (name.length() - 연속된 A가 끝나는 지점) * 2 + i 
	        
	        
	        int move = name.length() - 1; //오른쪽으로 쭉 간 횟수
	        
	        for(int i = 0; i<name.length(); i++) {
	        	// 조이스틱 상하 조작으로 원하는 알파벳 조작.
	        	answer += Math.min(name.charAt(i) - 'A', 26-(name.charAt(i)-'A')); 
	        	
	        	// i가 name.length 길이가 초과히지 않고, 다음 인덱스가 'A' 문자인 경우
	        	if(i<name.length()-1 && name.charAt(i+1) =='A') {
	        		//연속되는 A 갯수 확인
	        		int endA = i+1; // 처음 나온 A 인덱스 위치 저장.
	        		while(endA < name.length() && name.charAt(endA) == 'A') {
	        			endA++;
	        			// 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
	        			move = Math.min(move, i*2 + (name.length() - endA)); // 오른쪽으로 이동
	        			move = Math.min(move, i+ (name.length() - endA)*2); // 왼쪽으로 이동
	        		}
	        		
	        	}
	        }
	        
	        
	        return answer + move;
	    }
	}
}
