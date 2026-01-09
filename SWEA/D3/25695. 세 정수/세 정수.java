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
            int x = sc.nextInt(); // max(A, B)
            int y = sc.nextInt(); // max(B, C)
            int z = sc.nextInt(); // max(C, A)
            // x == y == z면 남은 1개의 수를 알 수 없음 -> 모두 같은 경우 제시
            
            int max = Integer.max(x, Integer.max(y, z));
            if (x == y && x == z && y == z) {
                sb.append(x).append(' ').append(y).append(' ').append(z).append('\n');
            }
            else if (max == x && max == y) {
                // b가 최댓값
                sb.append(z).append(' ').append(y).append(' ').append(z).append('\n');
            } else if (max == x && max == z) {
                // a가 최댓값
                sb.append(x).append(' ').append(y).append(' ').append(y).append('\n');
            } else if (max == y && max == z) {
                  // c가 최댓값
                sb.append(x).append(' ').append(x).append(' ').append(z).append('\n');
            } else {
                sb.append(-1).append(' ').append(-1).append(' ').append(-1).append('\n');
            }
        }
        System.out.println(sb.toString());
	}
}