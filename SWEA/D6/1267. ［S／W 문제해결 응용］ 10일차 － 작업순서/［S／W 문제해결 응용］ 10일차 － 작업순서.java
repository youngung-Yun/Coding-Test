import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Solution {

    static List<List<Integer>> adj;
    static boolean[] visited;
    static Deque<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; ++testCase) {
            stack = new ArrayDeque<>();
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            adj = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                adj.add(new ArrayList<>());
            }
            visited = new boolean[v+1];

            stk = new StringTokenizer(bf.readLine());
            for (int i = 0; i < e; i++) {
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                adj.get(a).add(b);
            }

            for (int i = 1; i <= v; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(i);
            }

            sb.append('#').append(testCase).append(' ');
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int curr) {
        for (int next : adj.get(curr)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
        stack.push(curr);
    }
}