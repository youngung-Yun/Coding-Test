import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 크루스칼 알고리즘으로 풀기
        StringTokenizer token = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            edges[i] = new int[] {a, b, c};
        }
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

        parent = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        rank = new int[v+1];

        int answer = 0;
        int count = 0;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            if (find(a) == find(b)) {
                continue;
            }
            if (union(a, b)) {
                answer += c;
                count += 1;
            }
            if (count == v - 1) {
                break;
            }
        }
        System.out.println(answer);
    }

    static int find(int x) {
        // 경로 압축
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        // 같은 집합이면 false
        if (parentX == parentY) {
            return false;
        }

        // union by rank : 랭크가 더 큰 쪽이 부모가 됨
        if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else {
            // 랭크가 같으면 한 쪽이 부모가 되고 rank 1 증가됨
            int min = Integer.min(parentX, parentY);
            int max = Integer.max(parentX, parentY);
            parent[max] = min;
            rank[min] += 1;
        }

        return true;
    }

}