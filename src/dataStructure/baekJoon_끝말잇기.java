package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class baekJoon_끝말잇기 {
	static StringBuilder sb;

	static void followUp() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int wordTotal = Integer.parseInt(br.readLine());

		Set<String> word = new LinkedHashSet<>();
		String list[] = new String[wordTotal];

		// 물음표의 순번
		int index = 0;

		// 현재 끝말 잇기 순서
		for (int i = 0; i < wordTotal; i++) {
			String str = br.readLine();
			word.add(str);
			list[i] = str;
			if (str.equals("?")) {
				index = i;
			}
		}

		int listTotal = Integer.parseInt(br.readLine());

		// 들어갈 낱말 목록
		List<String> copy = new ArrayList<>();

		for (int i = 0; i < listTotal; i++) {
			String str = br.readLine();
			copy.add(str);
		}

		String frist = list[index - 1];
		String last = list[index + 1];

		// 중복된 단어를 제외한 값 배열 목록
		copy.removeAll(word);
		// 중복된 단어 배열 목록
		// copy.retainAll(word);
		sb = new StringBuilder();

		Iterator<String> iter = copy.iterator();

		while (iter.hasNext()) {
			String str = iter.next();
			if (frist.charAt(frist.length() - 1) == str.charAt(0)
					&& last.charAt(0) == str.charAt(str.length() - 1)) {
				sb.append(str);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		followUp();
		System.out.println(sb);
	}

}
