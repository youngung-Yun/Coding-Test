import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int MAX = 1_000_000;
    static int[] parent = new int[MAX+1];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(parent, -1);
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            String command = stk.nextToken();
            if (command.equals("I")) {
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                union(a, b);
            } else if (command.equals("Q")) {
                int robot = Integer.parseInt(stk.nextToken());
                System.out.println(-parent[find(robot)]);
            }
        }
    }

    private static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return;
        }

        if (-parent[parentX] > -parent[parentY]) {
            parent[parentX] += parent[parentY];
            parent[parentY] = parentX;

        } else {
            parent[parentY] += parent[parentX];
            parent[parentX] = parentY;
        }
    }
}