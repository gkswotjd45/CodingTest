package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class baejoon_양말짝맞추기 {
	static StringBuilder sb;
	static void pair() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> socks = new HashMap<>(); 
		for(int i = 0; i<5; i++) {
			int num = Integer.parseInt(br.readLine());
			socks.put(num,socks.getOrDefault(num, 0)+1);
		}
		
		// 짝이 일치 않는 값만 찾아오기
		Iterator<Map.Entry<Integer, Integer>> entries =  socks.entrySet().iterator();
		sb = new StringBuilder();
		while(entries.hasNext()) {
			Map.Entry<Integer,Integer> etrie = entries.next();
			if(etrie.getValue() % 2 == 1) {
				sb.append(etrie.getKey());
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		pair();
		System.out.println(sb);
	}
}
