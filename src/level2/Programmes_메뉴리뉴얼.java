package level2;

import java.util.*;

//public class Programmes_메뉴리뉴얼 {
//    static class Solution {
//        List<Map<String, Integer>> FoodMaps = new ArrayList<>();
//        int[] MaxCnt = new int[11]; // 메뉴 갯수별 가장 빈도가 많은 값
//
//        void comb(char[] str, int pos, StringBuilder candi, int depth) {
//
//            // 재귀 호출의 깊이만큼 들여쓰기를 생성합니다.
//            char[] indent = new char[depth * 2];
//            Arrays.fill(indent, ' ');
//            System.out.println(new String(indent) + "comb(" + new String(str) + ", " + pos + ", " + candi + ")");
//
//            // 위치가 문자열 끝에 위치한 경우
//            if (pos >= str.length) {
//                int len = candi.length();
//                if (len >= 2) {
//                    int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
//                    FoodMaps.get(len).put(candi.toString(), cnt);
//                    MaxCnt[len] = Math.max(MaxCnt[len], cnt);
//                }
//                return;
//            }
//
//            // 선택하는 것 
//            comb(str, pos + 1, candi.append(str[pos]), depth + 1);
//            candi.setLength(candi.length() - 1);
//            comb(str, pos + 1, candi, depth + 1);
//        }
//
//        public String[] solution(String[] orders, int[] course) {
//
//            for (int i = 0; i < 11; i++) {
//                FoodMaps.add(new HashMap<String, Integer>());
//            }
//            
//            for (String str : orders) {
//
//                char[] arr = str.toCharArray();
//                Arrays.sort(arr);
//                comb(arr, 0, new StringBuilder(), 0);
//
//            }
//
//            List<String> list = new ArrayList<>();
//            for (int len : course) {
//                for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
//                    if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
//                        list.add(entry.getKey());
//                    }
//                }
//            }
//            Collections.sort(list);
//
//            String[] answer = new String[list.size()];
//
//            for (int i = 0; i < list.size(); i++) {
//                answer[i] = list.get(i);
//            }
//            return answer;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
//        int[] course = { 2, 3, 4 };
//
//        String[] arr = solution.solution(orders, course);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//}

public class Programmes_메뉴리뉴얼 {
	static class Solution {
		// FoodMaps은 각 음식 조합의 출현 횟수를 저장하는 Map.
		// 각 map은 음식오합을 키로, 그 조합의 출현 횟수를 값으로 갖음. ex) {AC,2}
		List<Map<String, Integer>> FoodMaps = new ArrayList<>();
		int[] MaxCnt = new int[11]; // 메뉴 갯수별 가장 빈도가 많은 값

		//음식 조합을 찾기 위한 재귀 함수 
		// 문자열, 그 문자열의 위치, 그리고 현재까지 만든 조합을 인자로 받음)
		void comb(char[] str, int pos, StringBuilder candi) {
			
			// 위치가 문자열 끝에 위치한 경우
			if (pos >= str.length) {
				int len = candi.length();
				// 메뉴가 2개 이상일 때 저장.
				if (len >= 2) {
					int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
					FoodMaps.get(len).put(candi.toString(), cnt);
					MaxCnt[len] = Math.max(MaxCnt[len], cnt);

				}
				return;
			}
			// 선택하는 것 
			comb(str, pos + 1, candi.append(str[pos]));
			candi.setLength(candi.length() - 1);
			comb(str, pos + 1, candi);

		}

		public String[] solution(String[] orders, int[] course) {

			// order 배열의 원소 크기는 최대 10 이상인 문자열.
			// 하나의 손님이 단품메뉴의 개수는 10개 => 단품의 음식은 총 10자리 항목만 가능
			for (int i = 0; i < 11; i++) {
				FoodMaps.add(new HashMap<String, Integer>());
			}
			
			// 모든 메뉴 구성에 대한 조합을 만듬
			for (String str : orders) {

				// 순열 방식은 정렬이 필요함
				char[] arr = str.toCharArray();
				Arrays.sort(arr);
				comb(arr, 0, new StringBuilder());

			}

			List<String> list = new ArrayList<>();
			for (int len : course) {
				for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
					if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
						list.add(entry.getKey());
					}
				}
			}
			Collections.sort(list);

			String[] answer = new String[list.size()];

			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		String[] arr = solution.solution(orders, course);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
