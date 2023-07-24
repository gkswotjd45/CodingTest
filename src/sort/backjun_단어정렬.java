package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class backjun_단어정렬 {
	static StringBuilder sb;

	public static void sort() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();

		int totalWord = Integer.parseInt(br.readLine());
		String[] word = new String[totalWord];
		
		for (int i = 0; i < totalWord; i++) {
			st = new StringTokenizer(br.readLine());
			word[i] = st.nextToken();
		}

		// 단어 길이가 짧은 순서 부터 오름차순으로 정렬 => 길이 짧은게 동일하면 알파벳 순으로 정렬
		Arrays.sort(word, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 1차 비교조건인 글자수가 동일하다면
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2); // 알파벳 글자 순으로 오름차순 정렬
				} else
					return o1.length() - o2.length();
			}
		});
	
		// word 배열에 중복을 없애기 위해 LikedHash을 사용.
		LinkedHashSet<String> linked = new LinkedHashSet<>(Arrays.asList(word));
		
		// LinkedHashSet을 배열로 변환
		String [] result = linked.toArray(new String[0]);
		
		sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]+"\n");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		sort();
		System.out.println(sb);
	}

}
