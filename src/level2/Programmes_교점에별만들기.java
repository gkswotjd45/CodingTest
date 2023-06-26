package level2;

import java.util.Arrays;
import java.util.HashSet;

public class Programmes_교점에별만들기 {
	
	// 좌표 클래스 생성
	static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Solution {
	static long minx= Long.MAX_VALUE, miny= Long.MAX_VALUE;
    static long maxx= Long.MIN_VALUE, maxy= Long.MIN_VALUE;

	public String[] solution(int[][] line){
		String[] answer = {};
		HashSet<Point>pSet = new HashSet<>();
		
		//2개의 직선에 대한 각각의 기울기에 대한 x,y 좌표
		//x 좌표 = (bf-ed)/ (ab- bc)
		//y 좌표 = (ec-af)/(ab-bc)
		long x, y;
		
		// for문을 돌면서 두 직선들의 교점을 구하고, 구한 교점들을 hashSet에 넣어 줌
		// if (AD-BC)==0 이면, 두 직선은 평행하다고 볼 수 있습니다
		// 두 교점이 정수가 아닌지 판별하여, 구한 교점 x,y가 모두 정수인건만 HashSet<Point>에 넣어줌
		// 구한 교점으로 x의 최대값, x의 최솟값, y의 최대값, y의 최솟값을 구하여 갱신해나갑니다.
		for(int i = 0; i<line.length-1; i++) {
			long a = line[i][0];
			long b = line[i][1];
			long e = line[i][2];
			for(int j = i+1; j<line.length; j++) {
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];
				
				long adbc= a*d-b*c;
				if(adbc==0) continue; // 비교대상이 직선일 경우
				
				long bfed= b*f-e*d;
				if(bfed%adbc!=0) continue; // x좌표가  소수점으로 떨어진다면
				
				long ecaf= e*c-a*f;
				if(ecaf%adbc!=0) continue; // y가 정수가 아님
				
			    x= bfed/adbc;
                y= ecaf/adbc;
                pSet.add(new Point(x, y));
                
                minx= Math.min(minx, x);
                miny= Math.min(miny, y);
                maxx= Math.max(maxx, x);
                maxy= Math.max(maxy, y);
				
			}
		}
		
		// 구한 maxx, maxy, minx, miny로 구한 교점들을 넣을 판의 height, width를 구함
		long height= maxy-miny+1;
        long width= maxx-minx+1;
		
		// answer = new String[height]로 판을 만들어주고, 일단 점으로 채움 ex)............
		answer = new String[(int)height];
		StringBuilder sb = new StringBuilder();
		
		// 가로 길이 만큼 "." 삽입
		 for(int i=0; i<width; i++){
	            sb.append(".");
	     }
		Arrays.fill(answer, sb.toString());
		// set에 넣어뒀던 교점들을 순회하면 answer판에 "*"을 넣어줌
		long nx, ny;
        for(Point p: pSet){
            ny= maxy-p.y;
            nx= p.x-minx;
            answer[(int)ny]= answer[(int)ny].substring(0, (int)nx)+"*"
                        +answer[(int)ny].substring((int)nx+1);
        }
        
        return answer;
		
	}
}

//	    public String[] solution(int[][] line) {
//	        String[] answer = {};
//	        double [][] grobe = new double[100][2]; 
//	        // line = [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]
//	        for(int i=0; i<line.length; i++) {
//	        	for (int j = 1; j<line[0].length; j++) {
//	        		int x_u = line[i][1] * line[j][2] - line[i][2]*line[j][1];
//	        		int x_b = line[i][0] * line[j][1] - line[i][1]*line[j][0];
//	        		
//	        		int y_u = line[i][2] * line[j][0] - line[i][0]*line[j][0];
//	        		int y_b = line[i][0] * line[j][1] - line[i][1]*line[j][0];
//	        		
//	        		double x = x_u / x_b;
//	        		double y = y_u / y_b;
//	        		
//	        		grobe[j-1][0] = x;
//	        		grobe[j-1][1] = y;
//	        	}
//	        }
//	        
//	        return answer;
//	    }
//	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [][] array = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		String[] result = solution.solution(array);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
			System.out.println();
		}
		

	}

}
