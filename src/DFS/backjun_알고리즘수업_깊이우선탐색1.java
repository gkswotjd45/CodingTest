package DFS;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
	
	public class backjun_알고리즘수업_깊이우선탐색1 {
		static StringBuilder sb;
		static int cnt; 
		static int totalNode;
		static int totalLine;
		static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 2차원 배열을 저장할 arraylist
		static int vistied[];
		public static void pratice() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			
			totalNode = Integer.parseInt(st.nextToken()); // 노드 총개수
			totalLine = Integer.parseInt(st.nextToken()); // 간선의 총개수
			int start = Integer.parseInt(st.nextToken()); // 시작 노드 
			
			vistied = new int[totalNode + 1];
			
			// 그래프 초기화 
			// 연결된 노드들을 나열하기 위해 ArrayList 중첩을 사용
			// Arraylist에 데이터를 저장하고 읽어오기 전에 두번에 걸쳐 새 인스턴스를 생성하여 초기화 시키도록 한다.
			for(int i = 0; i<= totalNode; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			// 그래프 저장
			for(int i=0; i<totalLine; i++) {
				st = new StringTokenizer(br.readLine());
				
				int u =  Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			// 그래프를 오름차순으로 정렬
			for(int i = 1; i<= totalNode; i++ ) {
				Collections.sort(graph.get(i));
			}
			cnt = 1; //첫번째 방문 순서 기록
			sb = new StringBuilder();
			DFS(start);
			
			for(int i = 1; i<vistied.length; i++) {
				
				sb.append(vistied[i]).append("\n");
			}
			
		}
		
		public static void DFS(int nodeIndex) {
			vistied[nodeIndex] = cnt;
			
			for(int i = 0; i<graph.get(nodeIndex).size(); i++) {
				int newNode = graph.get(nodeIndex).get(i);
				
				if (vistied[newNode] == 0) {
					cnt++;
					DFS(newNode);
				}
			}
		}
		public static void main(String[] args) throws IOException {
			pratice();
			System.out.println(sb);
	
		}
	
	}

