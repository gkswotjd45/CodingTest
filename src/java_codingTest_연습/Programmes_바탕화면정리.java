package java_codingTest_연습;

public class Programmes_바탕화면정리 {
	static class Solution {
	    public int[] solution(String[] wallpaper) {
//	        int[] answer = {};
//	        int[][] check = new int[wallpaper.length][wallpaper[0].length()];
//	        int k = 0;
//	        for(int i= 0; i<wallpaper.length; i++) {
//	        	for(int j = 0; j<wallpaper[0].length(); j++) {
//	        		if(wallpaper[i].charAt(j) == '#') {
//	        			check[k][0] = i;
//	        			check[k][1] = j;
//	        		}
//	        	}
//	        }
//	        
//	        int x = check[0][0];
//	        int y = check[0][1];
//	        
//	        // check 배열에는 check = {{2,3}, {2,5}, {3,1}} 있다고 가정해보면 
//	        for(int i = 0; i<check.length; i++) {
//	        	
//	        	Math.max(x, check[i][0]);
//	        		
//	        	}
//	        	
//	        }
	        
	    	// 시작x, 시작 y, 끝 x, 끝 y
	    	int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, rdx = 0, rdy = 0;
	    	
	    	for(int i = 0; i<wallpaper.length; i++) {
	    		String wp = wallpaper[i];
	    		for(int j = 0; j<wallpaper[i].length(); j++) {
	    			if(wp.charAt(j)=='#') {
	    				lux = Math.min(lux, i);
	    				luy = Math.min(luy, j);
	    				rdx = Math.max(rdx, i+1);
	    				rdy = Math.max(rdy, j+1);
	    			}
	    		}
	    	}
	    	return new int[] {lux,luy,rdx,rdy};
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String [] arr = {".#...", "..#..", "...#."};
		System.out.println(solution.solution(arr));
	
	}
}
