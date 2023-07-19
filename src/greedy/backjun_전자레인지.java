package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjun_전자레인지 {
	static StringBuilder sb; // 결과값
	
	public static void electronic() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int time = Integer.parseInt(br.readLine());
		int [] cooking = new int[3];
		sb = new StringBuilder();
		while(time > 0) {
			if (time/300 !=0) {
				cooking[0] = time / 300; // A 항목에 저장
				time %= 300; 
			}
			if(time/60 !=0) {
				cooking[1] = time/ 60; // B 항목에 저장
				time %= 60;
			}
			if(time/10 != 0) {
				cooking[2] = time/ 10;
				time %= 10;
			}else if (time>=1 && time < 10) {
				cooking[0] = -1;
				break;
			}
			
		}
		
		if(cooking[0]== -1) {
			sb.append(cooking[0]);
		}else 
		{
			sb.append(cooking[0]+" ");
			sb.append(cooking[1]+" ");
			sb.append(cooking[2]);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		electronic();
		System.out.println(sb);
	}
}
