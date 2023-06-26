package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Programmes_수식최대화 {

	static class Solution {
		static List<List<String>> list = new ArrayList<>();

		public long solution(String expression) {
			long answer = 0;
			boolean[] visited = new boolean[3];
			String[] operationTypes = { "-", "+", "*" };

			permutation(new ArrayList<>(), operationTypes, visited);

			List<Long> numbers = Arrays.stream(expression.replaceAll("-|\\+|\\*", " ").split(" ")).map(Long::parseLong)
					.collect(Collectors.toList());
			System.out.println("수식에서 숫자들: " + numbers); // 수식에서 추출한 숫자들을 출력합니다.

			List<String> collect = Arrays.stream(expression.replaceAll("[0-9]", "").split(""))
					.collect(Collectors.toList());
			System.out.println("수식에서 연산자들: " + collect); // 수식에서 추출한 연산자들을 출력합니다.

			for (List<String> strings : list) {
				System.out.println("현재 우선 순위: " + strings); // 현재 연산자 우선순위를 출력합니다.
				long current = solve(strings, numbers, collect);
				System.out.println("현재 결과: " + current); // 현재 우선 순위에 따른 결과 값을 출력합니다.
				answer = Math.max(answer, current);
			}

			return answer;
		}

		static long calc(long one, long two, String calc) {
			switch (calc) {
			case "-":
				return one - two;
			case "+":
				return one + two;
			default:
				return one * two;
			}
		}

		static long solve(List<String> strings, List<Long> numbers, List<String> operations) {
			List<Long> numbersClone = new ArrayList<>(numbers);
			List<String> operationsClone = new ArrayList<>(operations);

			// strings에 전달받은 연산자들 ex) -, *, + 을 각각 가져와서 연산 수행.
			for (int i = 0; i < strings.size(); i++) {
				String operation = strings.get(i);
				// 
				for (int j = 0; j < operationsClone.size(); j++) {
					if (operation.equals(operationsClone.get(j))) {
						long front = numbersClone.get(j);
						long back = numbersClone.get(j + 1);
						long temp = calc(front, back, operation);

						numbersClone.remove(j + 1);
						numbersClone.remove(j);
						operationsClone.remove(j);

						numbersClone.add(j, temp);

						j--;
					}
				}

				System.out.println("중간 연산 결과: " + numbersClone); // 중간 연산 결과를 출력합니다.
			}

			return Math.abs(numbersClone.get(0));
		}

		static void permutation(ArrayList<String> arrayList, String[] orders, boolean[] visited) {
			if (arrayList.size() == 3) {
				list.add(new ArrayList<>(arrayList));
				System.out.println("생성된 연산자 순열: " + arrayList); // 생성된 연산자 순열을 출력합니다.
				return;
			}
			for (int i = 0; i < orders.length; i++) {
				if (!visited[i]) {
					arrayList.add(orders[i]);
					visited[i] = true;
					permutation(arrayList, orders, visited);
					visited[i] = false;
					arrayList.remove(arrayList.size() - 1);
				}
			}
 		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("100-200*300-500+20"));
		
	}
}
