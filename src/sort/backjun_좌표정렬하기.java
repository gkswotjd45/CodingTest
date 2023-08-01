package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjun_좌표정렬하기 {
	static StringBuilder sb;

	public static void sort() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());

		int dot[][] = new int[total][2];

		StringTokenizer st;
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			dot[i][0] = Integer.parseInt(st.nextToken());
			dot[i][1] = Integer.parseInt(st.nextToken());
		}

		// 정렬하기
		Arrays.sort(dot, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1]-o2[1];
				} else
					return o1[0] - o2[0];
			}
		});
		
		sb = new StringBuilder();
		
		for(int i=0; i<dot.length; i++) {
			for(int j=0; j<dot[0].length; j++) {
				sb.append(dot[i][j]).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		sort();
		System.out.println(sb);
	}
}
