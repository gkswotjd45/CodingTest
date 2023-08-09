package BruteForce;

public class baekJoon_셀프넘버 {
	static StringBuilder sb;
	static boolean[] check;
	static int size = 10000;

	static void self() {
		check = new boolean[size + 1];
		for (int i = 1; i < 10000; i++) {
			int answer = function(i);

			if (answer < 10000) {
				check[answer] = true;
			}
		}

		// 결과값을 출력.
		sb = new StringBuilder();
		for (int i = 1; i < 10000; i++) {
			if (check[i] == false) {
				sb.append(i).append("\n");
			}
		}

	}

	// 함수 동작
	public static int function(int i) {

		int result = i;
		// 10000 자리 인 경우
		if (result / 10000 != 0) {
			result += result / i;
			return result;
			// 1000 자리 인 경우
		} else if (result / 1000 != 0) {
			result += result / 1000;
			i = i % 1000; // 백의 자리수
			result += i / 100;
			i = i % 100; // 십의 자리수
			result += i / 10;
			i = i % 10; // 일의 자리수
			result += i;
			return result;
		}
		// 100자리 인 경우
		else if (result / 100 != 0) {
			result += result / 100;
			i = i % 100; // 십의 자리수
			result += i / 10;
			i = i % 10; // 일의 자리수
			result += i;
			return result;
		} else if (result / 10 != 0) {
			result += result / 10;
			i = i % 10; // 일의 자리수
			result += i;

			return result;
		} else {
			result += result / 1;
			return result;
		}
	}

	public static void main(String[] args) {
		self();
		System.out.println(sb);
	}
}
