package level2;

public class Programmes_점찍기 {
	static class Solution {
	    public long solution(int k, int d) {
	        long answer = 0;
	        // k는 이동 간격, d는 (x,y)의 최대 합
	        
	        for(int i= 0; i<=d; i+=0) {
	        	for(int j=0; j<=d; j+=0) {
	        		if(Math.pow(i, 2)+ Math.pow(j, 2) <= Math.pow(d, 2)) { 
	        			answer++;
	        			System.out.println("["+i+","+j+"]");
	        			j+=k;
	        		}else {
	        			j+=k;
	        		}
	        			
	        	}
	        	i+=k;
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		long result = solution.solution(2, 4);
		System.out.println(result);
	}
}
