package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.net.ssl.SNIHostName;
import javax.swing.event.AncestorEvent;

public class backjun_설탕배달 {
	
	static StringBuilder sb;
	
	public static void delivery() throws NumberFormatException, IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int weight = Integer.parseInt(br.readLine());
	int answer = 0;
	
	while(true) {
			if(weight % 5 == 0) {
				answer += weight/5;
				break;
			}else {
				if(weight<3) {
					answer = -1;
					break;
				}
				weight -= 3;
				answer++;
			}
		}
	sb = new StringBuilder();
	sb.append(answer +"\n");
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		delivery();
		System.out.println(sb);
	}
}
