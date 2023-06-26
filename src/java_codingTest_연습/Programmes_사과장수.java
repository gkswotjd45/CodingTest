package java_codingTest_연습;

import java.util.Arrays;

public class Programmes_사과장수 {


	
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);// 배열을 우선 정렬
        
        int tScore[] = new int[score.length];
        
        for(int i=0; i<score.length; i++) {
        	tScore[i] = score[score.length-1 -i];
        } // 배열의 역순 정렬 
        
        int index = 0;
        
       while(true) {
    	   if(index >= tScore.length || index+m >tScore.length) {
    		   break;
    	   }
    	   answer += tScore[index+m-1] * m;
    	   index += m;
       }
        
        return answer;
    }
}

