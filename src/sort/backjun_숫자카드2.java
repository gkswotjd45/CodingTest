package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class backjun_숫자카드2 {
	static StringBuilder sb;
	public static void numberCard() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sangeunTotal = Integer.parseInt(br.readLine());
		
		HashMap<String,Integer> map = new HashMap<>(); 
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		// 현재 상근이가 가지고 있는 숫자 목록
		while(st.hasMoreTokens()) {
			String str = st.nextToken(); 
			map.put(str, map.getOrDefault(str, 0) + 1);	
		}
		
		// 확인하고자 하는 숫자 항목 개수
		int checkTotal = Integer.parseInt(br.readLine());
		
		// 확인하고자 하는 숫자 항목 목록 저장
		String [] check = new String[checkTotal];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<checkTotal; i++) {
			check[i] = st.nextToken();
		}
		
		
		
		int answer [] = new int [checkTotal];
		sb = new StringBuilder();
		// 비교 수행 1
//		for(int i = 0; i<check.length; i++) {
//			Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
//			while(iter.hasNext()) {
//				Entry<String,Integer> entrySet = (Entry<String,Integer>) iter.next();
//				if(entrySet.getKey().equals(check[i])) {
//					answer[i] = entrySet.getValue();
//					break;
//				}
//			}
//		}
		
		// 비교 수행 2
		for(int i = 0; i<check.length ; i++) {
			
			answer[i] = map.getOrDefault(check[i], 0);
		}
		
		for(int i = 0; i<checkTotal; i++) {
			sb.append(answer[i]+" ");
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		numberCard();
		System.out.println(sb);
	}
}
