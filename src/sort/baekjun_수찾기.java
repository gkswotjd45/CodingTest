package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjun_수찾기 {
	static StringBuilder sb;

	public static void findNumber() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int setTotal = Integer.parseInt(br.readLine());
		int set[] = new int[setTotal];
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// 임의의 배열 값 설정
		int i = 0;
		while (st.hasMoreTokens()) {
			set[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		// 임의의 배열 정렬 [오름차순]
		Arrays.sort(set);

		int finalTotal = Integer.parseInt(br.readLine());
		int find[] = new int[finalTotal];
		st = new StringTokenizer(br.readLine());
		// 찾고자 하는 배열 값 저장
		i = 0;
		while (st.hasMoreTokens()) {
			find[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		sb = new StringBuilder();
		for (int j = 0; j < find.length; j++) {
			int answer;
			// 이진 배열로 원하는 값 찾기
			answer = BinaryIndex(set, find[j], 0, set.length - 1);
			sb.append(answer).append("\n");
		}

	}

	private static int BinaryIndex(int[] set, int findNumber, int left, int right) {
		// 왼쪽 인덱스 항목이 오른쪽 항목 값에 역전할 경우
		if (left > right)
			return 0;

		// 중간 값
		int mid = (left + right) / 2;

		// 찾는 값이 중간 값보다 클 경우
		if (set[mid] < findNumber) {
			return BinaryIndex(set, findNumber, mid + 1, right);
		}
		// 찾는 값이 중간 값보다 작은 경우
		else if (set[mid] > findNumber) {
			return BinaryIndex(set, findNumber, left, mid - 1);
		}
		// 값을 찾았다면
		else
			return 1;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		findNumber();
		System.out.println(sb);
	}
}
