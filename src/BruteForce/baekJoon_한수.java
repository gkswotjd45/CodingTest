package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekJoon_한수 {
	static StringBuilder sb;

	public static void hanSu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int result = 0;

		for (int i = 1; i <= Integer.parseInt(input); i++) {
			if (i < 10) {
				result++;
			} else {
				// 현재 숫자를 String(문자열) 형태로 변환 =>charAt을 통해 자리수를 확인하기 위해서
				String strNum = Integer.toString(i);
				
				// 마지막 숫자 인덱스를 구함.
				int last = strNum.length() - 1;
				
				// 해당 숫자의 마지막 자리와 한단계 앞인 자리에 대한 공차를 구함.
				int gocha = Character.getNumericValue(strNum.charAt(last))- Character.getNumericValue(strNum.charAt(last - 1));

				// 현재 숫자를 첫번쨰 자리부터 마지막 자리까지 순차적으로 위에서 구한 공차가 맞는지 여부를 확인.
				for (int j = 0; j < strNum.length() - 1; j++) {
					int first = Character.getNumericValue(strNum.charAt(j));
					int second = Character.getNumericValue(strNum.charAt(j + 1));
					
					// 공차와 현재 자리수에 대한 차이가 맞지 않는 경우 다음 숫자로 이동.
					if (gocha != (second - first)) {
						break;
					}
					// 현재 숫자가 마지막 자리수에 도달한 경우 결과값을 증가시킴.
					if(j+1 == strNum.length()-1) {
						result++;
					}
	
				}
			}

		}
		sb = new StringBuilder();
		sb.append(result);
	}

	public static void main(String[] args) throws IOException {
		hanSu();
		System.out.println(sb);

	}

}
