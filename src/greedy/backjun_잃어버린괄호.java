package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjun_잃어버린괄호 {
	static StringBuffer sb;
	
	public static void lost() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		String str = br.readLine(); // 입력받은 문자열
		sb = new StringBuffer(); //결과값 저장
		
		// 1. 뺼셈 (-)을 기준으로 1차적으로 문자열을 분리
		// 2. 분리된 문자열들을 각각에 포함된 정수 값들을 모두 더함
		// 3. 각각 더해진 값들을 뺄셈 함.
		
		StringTokenizer st = new StringTokenizer(str, "-");
		// 클래스 객체에서 다음을 읽어 들일 token이 있다면 true
		while(st.hasMoreTokens()) {
			int temp = 0;
			String token = st.nextToken();
			// 분리한 문자값에 + 연산 기호가 있다면, 정수를 더함
			StringTokenizer stplus = new StringTokenizer(token,"+");
			
		
			while(stplus.hasMoreTokens()) {
				temp += Integer.valueOf(stplus.nextToken());
			}

			// temp가 첫 번째 경우일 때만
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		sb.append(sum+"\n");	
		
	};
	public static void main(String[] args) throws Exception {
		lost();
		System.out.println(sb);
	}
}
