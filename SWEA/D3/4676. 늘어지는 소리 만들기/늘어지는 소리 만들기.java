import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			String str = br.readLine();
			int count = Integer.parseInt(br.readLine());
			// i번째 앞에 들어갈 하이픈 개수
			int[] hyphenCount = new int[str.length() + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < count; i++) {
				++hyphenCount[Integer.parseInt(st.nextToken())];
			}
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				for (int k = 0; k < hyphenCount[i]; k++) {
					tmp.append('-');
				}
				tmp.append(str.charAt(i));
			}
			for (int i = 0; i < hyphenCount[str.length()]; i++) {
				tmp.append('-');
			}
			sb.append('#').append(testCase).append(' ').append(tmp.toString()).append('\n');
		}
		System.out.println(sb);
	}
}