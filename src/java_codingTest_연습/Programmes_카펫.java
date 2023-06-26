package java_codingTest_연습;

public class Programmes_카펫 {
	static class Solution {
		public int[] solution(int brown, int yellow) {
			// 모든 wight, height의 조합
			for(int width = 3; width<=5000; width++) {
				for(int height = 3; height <= width; height ++) {
					int boundary = (width + height -2) *2 ; // 양쪽 측면
					int center = width * height - boundary;
					
					if(brown== boundary && yellow == center) {
						return new int[] {width,height};
					}
				}
			}
			return null;
		}
	}
}
