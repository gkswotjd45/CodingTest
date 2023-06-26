package java_codingTest_연습;

class Soulution{
	
	// 상하좌우 중 빈테이블이 있는 방향에 대해 초기값 설정
	private static final int dx[] = {0,-1,1,0};
	private static final int dy[] = {-1,1,0,0};
	
	// 해당 대기실이 거리두기를 지켜지고 있는지 파악
	public boolean isDistanced(char[][] room) {
		for(int y=0; y<room.length; y++) {
			for(int x=0; x<room[y].length; x++) {
				if(room[y][x] != 'P') continue;
				// 거리두기 검사
			}
		}
		return true;
	}
	
	// 대시길의 위치 정보를 넘겨주었을 때
	private boolean isDistanced(char[][] room, int x, int y) {
		for(int d = 0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(ny<0 || ny >= room.length || nx<0 ||nx>=room[ny].length) continue;
			//room[ny][ny]를 통해 다른 응시자에게 도달할 수 있는지 검사.
			switch (room[ny][nx]) {
			case 'P' : return false;
			case 'O' : 
				if(isNextToVolunteer(room,nx,ny,3-d)) return false;
				break;
			}
			
		}
		return true;
	}
	// 다음 지원자가 앉을 곳 
	private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
		
		for(int d = 0; d<4; d++) {
			if(d==exclude) continue;
			int nx = x +dx[d];
			int ny = y +dy[d];
			if(ny<0 || ny >= room.length || nx<0 ||nx>=room[ny].length) continue;
			if(room[ny][nx] == 'P') return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	public int[] solution(String[][] places) {
	int answer[] = new int[places.length];
	
	for(int i = 0; i<answer.length; i++) {
		String[] place = places[i]; // 대기실 크기
		char[][] room = new char[place.length][]; // 하나의 대기실 표현
		for(int j=0; j<room.length; j++) {
			room[j] = place[j].toCharArray();
		}
		// 거리두기 검사후 answer에 기록

			
		}
		return answer;
	}

}

public class Programmes_거리두기확인하기 {

}
