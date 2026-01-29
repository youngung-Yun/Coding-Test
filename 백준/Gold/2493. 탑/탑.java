import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Stack<Integer> sin = new Stack<>();
		Stack<int[]> sout = new Stack<>();

		for (int i = 0; i < n; i++) {
			sin.push(Integer.parseInt(st.nextToken()));
		}

		int[] result = new int[n];
		int index = n - 1;
		for (int i = 0; i < n; i++) {
			int temp = sin.pop();
			while (true) {
				if (sout.isEmpty() || sout.peek()[1] > temp) {
					sout.push(new int[] { index, temp });
					index--;
					break;
				}
				result[sout.pop()[0]] = n - i;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);

	}

}
