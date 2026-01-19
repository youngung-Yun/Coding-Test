import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; ++testCase) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			BigInteger sum = a.add(b);

			sb.append('#').append(testCase).append(' ').append(sum.toString()).append('\n');
		}
		System.out.println(sb);
	}
}