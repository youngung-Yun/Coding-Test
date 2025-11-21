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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		char[] colors = new char[] {'.', '#'};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt(), m = sc.nextInt();
			char[][] board = new char[n][m];
			for (int i = 0; i < n; i++) {
				String row = sc.next();
				for (int j = 0; j < m; j++) {
					board[i][j] = row.charAt(j);
				}
			}

			char[][] expected1 = new char[n][m];
			char[][] expected2 = new char[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((i + j) % 2 == 0) {
						expected1[i][j] = '.';
						expected2[i][j] = '#';
					} else {
						expected1[i][j] = '#';
						expected2[i][j] = '.';			
					}
				}
			}
			
			boolean flag1 = true, flag2 = true;
			for (int i = 0; i < n; i++) {
				if (!flag1 && !flag2) {
					break;
				}
				for (int j = 0; j < m; j++) {
					if (board[i][j] == '?') {
						continue;
					}
					if (board[i][j] != expected1[i][j]) {
						flag1 = false;
					}
					if (board[i][j] != expected2[i][j]) {
						flag2 = false;
					}
				}
			}

			System.out.printf("#%d %s\n", test_case, flag1 || flag2 ? "possible" : "impossible");
		}
	}
}