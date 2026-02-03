import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static char[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());
            tree = new char[200 * 3];
            for (int i = 0; i < n; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(token.nextToken());
                char root = token.nextToken().charAt(0);
                tree[number] = root;
                if (token.hasMoreTokens()) {
                    char left = token.nextToken().charAt(0);
                    tree[number*2] = left;
                }
                if (token.hasMoreTokens()) {
                    char right = token.nextToken().charAt(0);
                    tree[number*2+1] = right;
                }
            }
            sb.append('#').append(testCase).append(' ').append(isCalculable(1) ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isCalculable(int root) {
        // 리프 노드는 반드시 숫자여야 함
        if (tree[root*2] == '\u0000' && tree[root*2+1] == '\u0000') {
            return Character.isDigit(tree[root]);
        }

        // 리프 노드 이외에는 전부 연산자여야 함
        return isCalculable(root * 2) && isCalculable(root * 2 + 1) && !Character.isDigit(tree[root]);
    }
}
