import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int max;
    static int[] ans;
    // [l, r, s]
    static int[][] archives;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; ++testCase) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            // 우리 개수
            int n = Integer.parseInt(token.nextToken());
            // 한 우리의 최대 마리 수
            int x = Integer.parseInt(token.nextToken());
            // 기록 개수
            int m = Integer.parseInt(token.nextToken());

            archives = new int[m][3];
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(bf.readLine());
                int l = Integer.parseInt(token.nextToken());
                int r = Integer.parseInt(token.nextToken());
                int s = Integer.parseInt(token.nextToken());
                archives[i] = new int[] {l, r, s};
            }

            max = -1;
            ans = new int[n];
            // 경우의 수 없는 경우를 위해
            Arrays.fill(ans, -1);

            dfs(new int[n], 0, n, x);

            sb.append('#').append(testCase).append(' ');
            if (ans[0] == -1) {
                sb.append(-1).append('\n');
            } else {
                for (int c : ans) {
                    sb.append(c).append(' ');
                }
                sb.append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static void dfs(int[] tmp, int depth, int n, int x) {
        if (depth == n) {
            int sum = checkCount(tmp, n);
            if (sum > max) {
                max = sum;
                ans = Arrays.copyOf(tmp, n);
            }
            return;
        }

        for (int i = 0; i <= x; i++) {
            tmp[depth] = i;
            dfs(tmp, depth + 1, n, x);
        }
    }

    // 총 햄스터 수 반환
    // 기록과 일치하지 않으면 -1 반환
    static int checkCount(int[] arr, int n) {
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        for (int[] archive : archives) {
            int left = archive[0];
            int right = archive[1];
            int count = archive[2];
            if (prefix[right] - prefix[left-1] != count) {
                return -1;
            }
        }
        return prefix[n];
    }
}
