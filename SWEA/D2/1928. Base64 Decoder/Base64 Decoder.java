
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringBuilder sb = new StringBuilder();
            String encoded = sc.next();

            for (int i = 0; i < encoded.length(); i += 4) {
                int sum = 0;
                // 문자 4개씩 끊어서 인코딩된 값 구하기
                for (int k = i; k < i + 4; k++) {
                    // 값 하나가 6비트 차지함
                    sum <<= 6;
                    char ch = encoded.charAt(k);
                    if (Character.isAlphabetic(ch)) {
                        if (Character.isUpperCase(ch)) {
                            sum += ch - 'A';
                        } else {
                            sum += ch - 'a' + 26;
                        }
                    } else if (Character.isDigit(ch)) {
                        sum += ch - '0' + 52;
                    } else if (ch == '+') {
                        sum += 62;
                    } else {
                        sum += 63;
                    }
                }
                // 최상위 비트부터 8비트씩 끊어 구함
                for (int k = 2; k >= 0; --k) {
                    int mask = 0b11111111 << k * 8;
                    int value = (sum & mask) >>> k * 8;
                    sb.append((char) value);
                }
            }

            System.out.printf("#%d %s\n", test_case, sb.toString());
        }
    }
}