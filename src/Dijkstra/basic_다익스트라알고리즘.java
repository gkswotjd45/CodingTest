package Dijkstra;

public class basic_다익스트라알고리즘 {
	static int number = 6; // 노드 6개 설정
	static int INF = 100000; // 무한대 값 설정 
	
	// 전체 그래프 초기화
	static int a[][] = {
			{0,2,5,1,INF,INF},
			{2,0,3,2,INF,INF},
			{5,3,0,3,1,5},
			{1,2,3,0,1,INF},
			{INF,INF,1,1,0,2},
			{INF,INF,5,INF,2,0}	
	};
	
	// 방문한 노드
	static boolean visited[] = new boolean [number]; 
	
	// 최단 거리 저장
	static int distinct[] = new int[number];
	
	// 가장 최소 거리 를 가지는 정점을 반환함.
	
	// 현재 방문하지 않았던 노드 중에서 가장 짧은 거리로 이동.
	public static int getSmallIndex() {
		
		int min = INF; // 초기값은 무한대 값
		int index = 0;
		for(int i =0 ; i< number; i++) {
			// 방문하지 않은 노드 중에서 현재 최소 값보다 더 작은 최단거리가 있다면
			if(distinct[i]< min && !visited[i]) {
				min = distinct[i];
				index = i; // 해당 인덱스 (위치) 저장
			}
		}
		return index;
	}
	
	// 다익스트라를 수행하는 메서드
	// 특정한 정점에서 부터 다른 모든 노드 정점을 구하는 함수
	
	public static void dijkstra(int start) {
		for(int i = 0; i< number; i++) {
			//시작점으로 부터 출발 했을 때, 모든 경로까지 비용을 담음
			distinct[i] = a[start][i];
		}
		// 시작 정점 방문값 설정
		visited[start] = true;
		
		for(int i = 0; i<number -2; i++) {
			int current = getSmallIndex();
			visited[current] = true;
			
			for(int j = 0; j<number ; j++) {
				if(!visited[j]) {
					if(distinct[current]+a[current][j] < distinct[j]) {
						distinct[j] = distinct[current]+ a[current][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		dijkstra(0);
		
		for(int i = 0; i<number; i++) {
			System.out.println(distinct[i]);
		}
		
	}
}
