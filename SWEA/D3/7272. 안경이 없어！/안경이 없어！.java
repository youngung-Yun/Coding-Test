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
import java.util.HashMap;
import java.util.Map;
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

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 0);
		map.put('D', 1);
		map.put('E', 0);
		map.put('F', 0);
		map.put('G', 0);
		map.put('H', 0);
		map.put('I', 0);
		map.put('J', 0);
		map.put('K', 0);
		map.put('L', 0);
		map.put('M', 0);
		map.put('N', 0);
		map.put('O', 1);
		map.put('P', 1);
		map.put('Q', 1);
		map.put('R', 1);
		map.put('S', 0);
		map.put('T', 0);
		map.put('U', 0);
		map.put('V', 0);
		map.put('W', 0);
		map.put('X', 0);
		map.put('Y', 0);
		map.put('Z', 0);

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str1 = sc.next(), str2 = sc.next();

			// 길이가 다르면 무조건 다른 문자
			if (str1.length() != str2.length()) {
				System.out.printf("#%d DIFF\n", test_case);
				continue;
			}

			boolean isSame = true;
			for (int i = 0; i < str1.length(); i++) {
				if (map.get(str1.charAt(i)) != map.get(str2.charAt(i))) {
					isSame = false;
					break;
				}
			}

			System.out.printf("#%d %s\n", test_case, isSame ? "SAME" : "DIFF");
		}
	}
}