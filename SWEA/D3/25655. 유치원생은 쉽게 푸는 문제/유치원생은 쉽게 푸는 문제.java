
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            if (n == 1) {
                sb.append(0).append('\n');
                continue;
            }
            // 1개짜리 숫자 2개보다 8 하나 넣는게 이득
            // n이 홀수일 경우 맨 앞자리에 4 넣는게 이득
            while (n > 0) {
                if (n % 2 == 1) {
                    sb.append(4);
                    n -= 1;
                    continue;
                }
                sb.append(8);
                n -= 2;
            }
            sb.append('\n');
		}
        System.out.println(sb);
	}
}