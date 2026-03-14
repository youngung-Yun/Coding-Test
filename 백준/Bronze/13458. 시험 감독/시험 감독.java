import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int mainDirector = Integer.parseInt(stk.nextToken());
        int subDirector = Integer.parseInt(stk.nextToken());

        long ans = 0L;
        for (int e : arr) {
            ++ans;
            e -= mainDirector;
            if (e > 0) {
                ans += (long) Math.ceil(1.0 * e / subDirector);
            }
        }
        System.out.println(ans);
    }
}