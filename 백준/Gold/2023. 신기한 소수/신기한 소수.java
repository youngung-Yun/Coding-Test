import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());

        for (int i = 1; i < 10; i++) {
            dfs(i, 1, n);
        }
        System.out.println(sb);
    }

    static void dfs(int curr, int depth, int n) {
        // 현재까지의 수가 소수인지 확인하여 소수 아니면 백트래킹
        if (!isPrimeNumber(curr)) {
            return;
        }
        if (depth == n) {
            sb.append(curr).append('\n');
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            curr *= 10;
            curr += i;
            dfs(curr, depth + 1, n);
            curr -= i;
            curr /= 10;
        }
    }

    static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        for (int i = 2; i <= (int) Math.floor(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
