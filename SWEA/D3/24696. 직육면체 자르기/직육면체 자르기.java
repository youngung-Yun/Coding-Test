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
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; ++testCase) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean existEven = false;
			for (int i = 0; i < 3; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (n % 2 == 0) {
					existEven = true;
					break;
				}
			}
			// 홀수 번 자르면 1의 승리, 짝수 번 자르면 2의 승리
			// 자르는 횟수 = l*w*h - 1
			// l, w, h 중 짝수가 하나라도 있으면 곱한 값은 짝수 = -1번 잘라서 홀수번 자르게 됨 = 1의 승리
			if (existEven) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}