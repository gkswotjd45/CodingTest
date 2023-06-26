package java_codingTest_연습;

public class Programmes_쿼드압축후개수세기 {
	static class Solution {
		static class Count {
			public final int zero; // 0의 개수 담기
			public final int one; // 1의 개수 담기

			public Count(int zero, int one) {
				this.zero = zero;
				this.one = one;
			}

			// 원소가 섞여 있는 경우 재귀 메서드를 사용하여 점화식에 따라 부분 문제를 해결
			public Count add(Count other) {
				return new Count(zero + other.zero, one + other.one);
			}
		}
			// 재귀 메서드 작성 
			// 정사각형의 범위 설정.
			public Count count(int offsetX, int offsetY, int size, int[][] arr) {
				int h = size / 2;
				// 현재 가로 세로 좌표 값과, 정사각형 한변의 길이. 현재 좌표 값을 담고 있는 내용
				for (int x = offsetX; x < offsetX + size; x++) {
					for (int y = offsetY; y < offsetY + size; y++) {
						if (arr[y][x] != arr[offsetY][offsetX]) {
							return count(offsetX, offsetY, h, arr).add(count(offsetX + h, offsetY, size, arr))
									.add(count(offsetX, offsetY + h, size, arr))
									.add(count(offsetX + h, offsetY + h, size, arr));// 원소가 섞여 있는 경우 반환
						}
					}
				}
				// 원소가 같은 값인 경우
				if (arr[offsetY][offsetX] == 1) {
					return new Count(0, 1); // 배열의 모든 값이 1
				}
				return new Count(1, 0); // 배열이 모든 값이 0
			}

		
		public int[] solution(int[][] arr) {
			Count count = count(0, 0, arr.length, arr);
			return new int[] { count.zero, count.one };
		}
	}
}
