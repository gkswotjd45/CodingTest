package java_codingTest_연습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 코테_입출력예제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// case 1. 첫 줄에 숫자의 갯수, 두 번째 줄 부터 숫자를 주어진 경우
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine()); // 첫번째 N 문자 입력받기
		
//		String[] str = new String[N]; // 숫자를 담을 공간 설정
		
//		for (int i = 0; N > i; ++i) { // String 배열에 입력받은 문자 담기
//	\`r[i] = br.readLine(); // 두번째 줄부터 ~~  한 줄씩 떼어서 임의 숫자값 전달.
//	\0}
//-+-	
//		for (int i = 0; N > i; ++i) {  // String 배열에 담긴 문자 출력
//			System.out.print(str[i] + " ");
//		}
		
		
		// case 2. 첫 줄에 숫자의 개수 N -> 두 번째 줄에 N개의 숫자가 띄어쓰기 없이 주어진 경우
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine()); // 첫 번째 물 문자 N 입력받기
//		
//		String str = br.readLine(); // 두 번쨰 줄 입력 받기.
//		
//		for (int i = 0; N > i; ++i) {  // 두번째 줄 문자 하나씩 N개 출력하기.
//			System.out.print(str.charAt(i) + " ");
//		}
//		
		// case3. 첫 줄에 숫자의 개수 N -> 두 번째 줄에 N개의 숫자와 공백이 함께 주어진 경우

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine()); // 첫번째 줄 문자 N 입력받기
//		
//		String str = br.readLine(); // 두번째 줄 입력 받기
//		StringTokenizer st = new StringTokenizer(str," ");// 입력 받은 두번 째 줄 공백을 기준으로 자르기
//		
//		for (int i = 0; N > i; ++i) {  // 잘린 순서대로 출력하기.
//			System.out.print(st.nextToken() + " ");
//		}
//		
		
//		// case 4 ,첫 줄에 숫자의 개수 N -> 두 번째 줄에 N개의 숫자와 콤마가 함께 주어진 경우
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine()); // 첫번째 줄 문자 N 입력받기
//		
//		String str = br.readLine();		// 두번째 줄 입력 받기
//		StringTokenizer st = new StringTokenizer(str, ","); // 입력받은 두번째 줄 공백을 기준으로 자르기
//
//		for (int i = 0; N > i; ++i) {  // 잘린 순서대로 출력하기.
//			System.out.print(st.nextToken() + " ");
//		}
		
		// 번외 입력받은 String 문자열을 sys.out 을 이용하지 않고, bufferWriter로 수행
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //선언
//		String s = "abcdefg";//예제 출력할 문자열
//		bw.write(s);//출력
//		bw.newLine(); //줄바꿈 // 자동 걔행이 존재하지 않음
//		bw.flush();//남아있는 데이터를 모두 출력시킴
//		bw.close();//스트림을 닫음
//		
	}
}
