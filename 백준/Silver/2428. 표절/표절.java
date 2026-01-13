import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] files = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
		long count = 0L;
		for (int i = 1; i < n; i++) {
			int low = 0;
			int high = i;
			while (low < high) {
				int mid = low + (high - low) / 2;
				if (check(files[mid], files[i])) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			// low = 검사해야 할 첫 번째 값의 인덱스
			count += (i - low);
		}
		System.out.println(count);
	}
	
	// 0.9배보다 작아야 조건 만족, Upper Bound
	static boolean check(long target, long curr) {
		return target * 10L < curr * 9L;
	}
}