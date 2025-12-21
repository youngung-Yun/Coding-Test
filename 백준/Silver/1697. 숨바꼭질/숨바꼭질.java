import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] pos = new int[100_001];
        boolean[] visited = new boolean[100_001];

        bfs(n, k, pos, visited);

        System.out.println(pos[k]);
    }

    private static void bfs(int start, int dest, int[] array, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            if (visited[dest]) break;

            int curr = queue.pollFirst();

            if (curr - 1 >= 0 && !visited[curr - 1]) {
                queue.addLast(curr - 1);
                visited[curr - 1] = true;
                array[curr - 1] = array[curr] + 1;
            }
            if (curr + 1 <= 100_000 && !visited[curr + 1]) {
                queue.addLast(curr + 1);
                visited[curr + 1] = true;
                array[curr + 1] = array[curr] + 1;
            }
            if (curr * 2 <= 100_000 && !visited[curr * 2]) {
                queue.addLast(curr * 2);
                visited[curr * 2] = true;
                array[curr * 2] = array[curr] + 1;
            }      
        }
    }
}
