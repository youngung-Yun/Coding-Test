import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    final static int MAX = 10 * 100;
    static int[] population;
    static int[][] adj;
    static int ans = MAX;
    static boolean canDivide = false;
    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(bf.readLine());
        population = new int[n+1];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(token.nextToken());
        }

        adj = new int[n+1][];
        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(token.nextToken());
            adj[i] = new int[c];
            for (int j = 0; j < c; j++) {
                adj[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        /*
         * 1. 부분집합으로 각 구역을 두 종류로 나눔
         * 2. 두 종류의 구역이 같은 구역들과 연결되어 있는지 확인. 연결 안되어있으면 불가능
         * 3. 인구수 차이 구함
         */
        dfs(new ArrayList<>(), new ArrayList<>(), 1, n);
        System.out.println(canDivide ? ans : -1);
    }

    static void dfs(List<Integer> red, List<Integer> blue, int number, int n) {
        if (number > n) {
            if (red.isEmpty() || blue.isEmpty()) {
                return;
            }
            if (isConnectedAll(red) && isConnectedAll(blue)) {
                canDivide = true;
                ans = Integer.min(ans, Math.abs(getPopulation(red) - getPopulation(blue)));
            }
            return;
        }

        red.add(number);
        dfs(red, blue, number + 1, n);
        red.remove(red.size() - 1);
        blue.add(number);
        dfs(red, blue, number + 1, n);
        blue.remove(blue.size() - 1);
    }

    static boolean isConnectedAll(List<Integer> nodes) {
        boolean[] isConnected = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(nodes.get(0));
        isConnected[nodes.get(0)] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int node : adj[current]) {
                if (isConnected[node] || nodes.indexOf(node) == -1) {
                    continue;
                }
                isConnected[node] = true;
                queue.offer(node);
            }
        }

        for (int node : nodes) {
            if (!isConnected[node]) {
                return false;
            }
        }
        return true;
    }

    static int getPopulation(List<Integer> nodes) {
        int sum = 0;
        for (int i : nodes) {
            sum += population[i];
        }
        return sum;
    }
}