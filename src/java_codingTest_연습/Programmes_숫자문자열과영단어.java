package java_codingTest_연습;

public class Programmes_숫자문자열과영단어 {
	public final static String[] words ={ "zero","one","two","three","four","five","six","seven","eight","nine","ten"};
	static class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        for(int i =0; i<words.length;i++) {
	        	//"one4seveneight => "1""4""7""8"
	        	s = s.replace(words[i], Integer.toString(i));
	        }
	        // "1""4""7""8" => 1478
	        return Integer.parseInt(s);
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution("one4seveneight");
		System.out.println(result);
	}
}
