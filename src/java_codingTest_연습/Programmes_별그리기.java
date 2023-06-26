package java_codingTest_연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	
	private static class Point{
	public final long x,y; // 1000*1000 크기 이내의 좌표 이므로,
	
	private Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
	
	// 두 직선상의 교점을 구함
	private Point intersectionl(long a1, long b1, long c1, long a2, long b2, long c2) {
		double x = (double) (b1 * c2 - b2 *c1) / (a1*b2 - a2 *b1);
		double y = (double) (a2 * c1 - a1 *c2) / (a1*b2 - a2 *b1);
		
		if(x % 1 != 0 || y % 1 != 0) return null; // 정수 일때 만 반환
	
		return new Point((long)x ,(long)y);
	}
	
	private Point getMininumPoint(List<Point> points) {
		
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;
		
		for(Point p : points) {
			if(p.x < x) x = p.x;
			if(p.y < y) y = p.y;
		}
		
		return new Point(x,y); // 가장 작은 좌표 찾기
	}
	
	private Point getMaxinumPoint(List<Point> points) {
		
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;
		
		for(Point p : points) {
			if(p.x> x) x = p.x;
			if(p.y> y) y = p.y;
		}
		
		return null; // 가장 큰 좌표값 찾기
		}
	
	public String[] soultion(int[][] line) { // 정수 좌표값만 저장,.
			List<Point> points = new ArrayList<>();
			for(int i = 0; i<line.length; i++) {
				for(int j = i+1; j<line.length; j++) {
					Point intersection = intersectionl(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
					
					if(intersection != null) {
						points.add(intersection);
					}
				}
			}
			Point minimum = getMininumPoint(points);
			Point maximum = getMaxinumPoint(points);
			
			// 2차원 배열 크기 결정
			int width = (int)(maximum.x - minimum.x +1); 
			int height = (int)(maximum.y - minimum.y+1);
			
			char[][] arr = new char[height][width];
			for(char[] row : arr) {
				Arrays.fill(row,'.');
			}
			
			for (Point p : points) {
				int x = (int) (p.x - minimum.x);
				int y = (int) (maximum.y - p.y);
				arr[y][x] = '*';
			}
			
			String [] result = new String[arr.length];
			for(int i = 0; i<result.length; i++) {
				result[i] = new String(arr[i]);
				
			}
			return result;
		}
	
	
	}


}


public class Programmes_별그리기 {

}
