package java_codingTest_연습;

public class Programmes_점의위치구하기 {
	static class Solution {
	    public int solution(int[] dot) {
	   
	        if(dot[0] > 0) return (dot[1]>0) ? 1: 4; // x좌표가 양수일 경우 1사분면 4사분면 모두에 해당. => y좌표 (양수) => 1사분면
	        else return (dot[1]<0) ? 3: 4; // x좌표가 음수일 경우 3사분면 4사분면에 해당 => y좌표 (양수) 4사분면.

	    }
	}
	
	public static void main(String[] args) {
		
	}
}
