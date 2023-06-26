package java_codingTest_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p67_slidingWindow {
	static int checkArr[];
	static char[] myArr;
	static int checkSecret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Dnalength = Integer.parseInt(st.nextToken()); // 임의로 받을 문자열의 길이
		int p = Integer.parseInt(st.nextToken()); // 슬라이드 윈도우 크기

		int Result = 0; // 결과값
		
		char Dnachar[] = new char[4]; // 입력받은 전체 임의의 Dna을 저장 배열.
		
		checkArr = new int[4]; // 비밀번호 염기서열 비교하는 배열
		myArr = new char[4]; // 현재 가지고 있는 염기서열 개수

		

		checkSecret = 0; // 현재 4개의 문자열 중에 몇가지가 만족하는지 => 4개가 맞으면 1증가

		Dnachar = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());

			if (checkArr[i] == 0) { // 0이라는 조건은 비밀번호 체크에서 한번도 사용하지 않는 문자열이므로 이미 비밀번호에 충족요건이 됨
				checkSecret++;

			}
		}

		for (int i = 0; i < p; i++) { // 부분문자열 처음받을 때 세팅
			Add(myArr[i]);

		}
		
		if(checkSecret == 4) Result++; // 비밀번호가 전부 다 충족했을 때
			
		//슬라이드 윈도우
		for(int i=p; i<Dnalength; i++) {
			int j = i-p;  // j는 가장 왼쪽 값 i는 가장 오른쪽의 값
			Add(Dnachar[i]);
			Remove(Dnachar[j]);
			if(checkSecret == 4) Result++;
		}
		
		System.out.println(Result);
		br.close();
	}

	private static void Add(char c) {
		// 임의의 염기서열을 받은 문자열을 현재 슬라이드 윈도우에 값으로 저장하기 삽입 과정
		switch (c) {
		case 'A': 
			myArr[0]++;
			if(myArr[0] == checkArr[0]) checkSecret++; // 현재 내 부분문자열과 확인 문자열에 완벽히 동일 하면 1 증가
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2]== checkArr[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		// 임의의 염기서열을 받은 문자열을 현재 슬라이드 윈도우에 값으로 저장하기 삽입 과정
		switch (c) {
		case 'A': 
			if(myArr[0] == checkArr[0]) checkSecret--; // 현재 내 부분문자열과 확인 문자열에 완벽히 동일 하면 1 증가
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2]== checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}
}
