import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; ++testCase) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			boolean turnOnAll = true;
			for (int i = 0; i < n; i++) {
				if ((m & (0b1 << i)) == 0) {
					turnOnAll = false;
					break;
				}
			}
			sb.append('#').append(testCase).append(' ').append(turnOnAll ? "ON" : "OFF").append('\n');
		}
		System.out.println(sb);
	}
}