package java_codingTest_연습;

	import java.util.Arrays;

public class Programmes_Hindex {
	public static boolean isValid(int[] citations, int h) {
		int count = 0;
		int index = citations.length - h;
		// h조건을 만족하려면 h회 이상 이용된 논문은 h개 이상
		for(int citation : citations) {
			if(citation >=h) count++;
		}
		// h조건 검사.
		return citations[index]>=h;
	}

	public static class Solution {
		public int solution(int[] citations) {
			int answer = 0;
			// h는 논문이 인용되는 횟수이자, 해당 횟수 이상 인용된 논문 개수
			// h 조건 검사
			Arrays.sort(citations); // 오름차순으로 정렬
			for(int h = citations.length;h>=1;h--)
			{
				{
					if (isValid(citations, h)) return h;
				}
			}
			return 0;
		}



	}
}