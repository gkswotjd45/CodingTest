package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakjun_1과2와3더하기 {
	static StringBuilder sb;
	static int T;
	public static void Calc() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		sb = new StringBuilder();
		
		for(int i= 0; i<T; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			answer = cumulativeOperation(Integer.parseInt(st.nextToken()));
			sb.append(answer+"\n");
		}
	
	
		
	}
	public static int cumulativeOperation(int number) {
		
		if(number == 3)
			return 4;
		else if (number == 2)
			return 2;
		else if (number == 1)
			return 1;
		else if (number == 0)
			return 0;
		else {
			return cumulativeOperation(number-3) + 
					cumulativeOperation(number-2) + 
					cumulativeOperation(number-1);
		}
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Calc();
		System.out.println(sb);

	}

}
