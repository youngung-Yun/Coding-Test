import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; ++testCase) {
            int n = Integer.parseInt(bf.readLine());
            char[] tree = new char[n+1];
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                StringTokenizer stk = new StringTokenizer(bf.readLine());
                int node = Integer.parseInt(stk.nextToken());
                char value = stk.nextToken().charAt(0);
                tree[node] = value;
                if (node * 2 <= n) {
                    stk.nextToken();
                }
                if (node * 2 + 1 <= n) {
                    stk.nextToken();
                }
            }
            inOrder(tree, 1, builder, n);
            sb.append('#').append(testCase).append(' ')
                    .append(builder.toString()).append('\n');
        }
        System.out.println(sb);
    }

    static void inOrder(char[] tree, int now, StringBuilder builder, int n) {
        if (now > n) {
            return;
        }

        inOrder(tree, now * 2, builder, n);
        builder.append(tree[now]);
        inOrder(tree, now * 2 + 1, builder, n);
    }
}