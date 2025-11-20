/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static int win;
	private static int lose;
	private static int[] kyuyoung = new int[9];
	private static int[] inyoung = new int[9];
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			win = lose = 0;

			boolean[] hasCard = new boolean[18 + 1];
			for (int i = 0; i < 9; i++) {
				kyuyoung[i] = sc.nextInt();
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean canHave = true;
				for (int number : kyuyoung) {
					if (i == number) {
						canHave = false;
						break;
					}
				}
				if (canHave) {
					inyoung[idx++] = i;
				}
			}

			dfs(0, 0, 0, new boolean[9]);

			System.out.printf("#%d %d %d\n", test_case, lose, win);
		}
	}

	private static void dfs(int curr, int opponentPoint, int myPoint, boolean[] visited) {
		// 게임 종료
		if (curr == 9) {
			if (opponentPoint < myPoint) {
				++win;
			} else if (opponentPoint > myPoint) {
				++lose;
			}
			return;
		}

		int opponentCard = kyuyoung[curr];
		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				continue;
			}
			int myCard = inyoung[i];
			int sum = opponentCard + myCard;

			visited[i] = true;
			if (opponentCard < myCard) {
				dfs(curr + 1, opponentPoint, myPoint + sum, visited);
			} else if (opponentCard > myCard) {
				dfs(curr + 1, opponentPoint + sum, myPoint, visited);
			}
			visited[i] = false;
		}
	}
}