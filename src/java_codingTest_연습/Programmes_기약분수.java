package java_codingTest_연습;

public class Programmes_기약분수 {
	static class Solutation {
		public int solution(int a, int b) {
			int answer = 2; // 조건에 충족 못하면 2
			// a>b
			// 1. 공약수로 약분하여 기약분수 만들기
			for(int i = 2; i<=a ; i++) {
				if(b%i==0 && a%i==0) {
					b= b/i;
					a = a/i;
					i--;
				}
			}
			// 분모가 2와 5로만 나누어지는 경우에만 기약분수 해당.
			while(b%2==0) {
				b= b/2;
			}
			while(b%5==0) {
				b=b/5;
			}
			if(b==1) {
				answer = 1;
			}
			
			return answer;
		}
	}
//	소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다. 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다. 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
//
//	기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
//	두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
//
//	제한사항
//	a, b는 정수
//	0 < a ≤ 1,000
//	0 < b ≤ 1,000
//	입출력 예
//	a	b	result
//	7	20	1
//	11	22	1
//	12	21                                	2
//	입출력 예 설명
//	입출력 예 #1
//
//	분수 7/20은 기약분수 입니다. 분모 20의 소인수가 2, 5 이기 때문에 유한소수입니다. 따라서 1을 return합니다.
//	입출력 예 #2
//
//	분수 11/22는 기약분수로 나타내면 1/2 입니다. 분모 2는 소인수가 2 뿐이기 때문에 유한소수 입니다. 따라서 1을 return합니다.
//	입출력 예 #3
//
//	분수 12/21는 기약분수로 나타내면 4/7 입니다. 분모 7은 소인수가 7 이므로 무한소수입니다. 따라서 2를 return합니다.
//	Hint
//	분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.
//	정수도 유한소수로 분류합니다.
//	※ 공지 - 2022년 11월 10일 테스트 케이스가 추가되었습니다. 기존에 제출한 코드가 통과하지 못할 수도 있습니다.
//	
// 기약 분수 -  분수로 표현된 분자와 분모가 1 이외의 공통된 약수로 더 이상 나누어 떨어지지 않는 형태가 된 것을 말한다. 분자와 분모를 1이외의 공통된 약수로 나누는
//	행위를 약분이라고 한다. 정수 a, b에 대해 분수 a/b가 기약 분수라는 것과 a,b가 서로 소 , 즉 최대공약수가 1이라는 것은 같은 말이다.
	
	//유클리드 호제법은 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다는 알고리즘
	// int uclid_fun(int p, q)
//	{
//		print("p = %d, q = %d\n",p,q);
//		if(q==0) {
//			printf("최대 공약수는 :%d\n", p);
//			return p; // 최대 공약수 
//		}
//		return uclid_fun(q,p%q)
//	}
	

		public static void main(String[] args) {

		}
	
}
