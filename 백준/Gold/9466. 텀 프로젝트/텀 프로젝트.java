import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] choices;
    static boolean[] visited;
    static boolean[] finished;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for (int testcase = 0; testcase < t; testcase++) {
            n = Integer.parseInt(bf.readLine());
            ans = n;
            choices = new int[n+1];

            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                choices[i] = Integer.parseInt(stk.nextToken());
            }

            visited = new boolean[n+1];
            finished = new boolean[n+1];

            for (int student = 1; student <= n; student++) {
                if (visited[student]) {
                    continue;
                }
                dfs(student);
            }
            System.out.println(ans);
        }
    }

    private static void dfs(int now) {
        visited[now] = true;
        int next = choices[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            // 사이클
            if (!finished[next]) {
                while (next != now) {
                    finished[next] = true;
                    --ans;
                    next = choices[next];
                }
                --ans;
            }
        }
        finished[now] = true;
    }
}