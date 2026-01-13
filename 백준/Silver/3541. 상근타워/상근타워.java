import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long minFloor = 1_000_000L * 1_000L + 1L;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			long up = Long.parseLong(st.nextToken());
			long down = Long.parseLong(st.nextToken());
			long floor = binarySearch(0, n + 1, up, down, n);
			minFloor = Long.min(minFloor, floor);
		}
		System.out.println(minFloor);
	}
	
	static long binarySearch(long l, long h, long up, long down, long n) {
		long low = l;
		long high = h;
		while (low < high) {
			long mid = low + (high - low) / 2L;
			long target = getFloor(up, down, mid, n);
			if (target <= 0) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return getFloor(up, down, low, n);
	}
	
	static long getFloor(long up, long down, long upCount, long n) {
		return (up * upCount) - (down * (n - upCount));
	}
}
