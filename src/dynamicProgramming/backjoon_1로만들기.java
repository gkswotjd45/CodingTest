package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_1로만들기 {
	static StringBuilder sb;

	static int[] classfy;

	public static void one() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		// 분류표에 넣을 저장공간
		classfy = new int[num +1];

		// 분류표 값 초기화
		classfy[0] = 0;
		classfy[1] = 0;
		
		// 원하는 정수의 최소값을 찾기
		min(num);
		sb = new StringBuilder();
		
		sb.append(classfy[num]);
	}

	private static int min(int num) {
		
		for(int i = 2; i<=num; i++) {
			
			classfy[i] = classfy[i-1] + 1;
			if(i%3 ==0 && classfy[i] > classfy[i/3] + 1) {
				classfy[i] = classfy[i/3] + 1;
			}
			if(i%2 == 0 && classfy[i] > classfy[i/2] + 1) {
				classfy [i] = classfy[i/2] + 1;
			}
			
		}
		return classfy[num];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		one();
		System.out.println(sb);
	}
}
