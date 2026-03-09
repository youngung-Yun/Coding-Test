import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int moveCount = 0;
    static int[] parent;
    static int[] leftChild;
    static int[] rightChild;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        leftChild = new int[n+1];
        rightChild = new int[n+1];
        parent = new int[n+1];
        parent[1] = -1;
        visited = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(stk.nextToken());
            int left = Integer.parseInt(stk.nextToken());
            int right = Integer.parseInt(stk.nextToken());
            leftChild[node] = left;
            rightChild[node] = right;

            if (left != -1) {
                parent[left] = node;
            }
            if (right != -1) {
                parent[right] = node;
            }
        }

        int last = getLast(1);

        similarInorder(1, last);

        System.out.println(moveCount);
    }

    private static void similarInorder(int root, int last) {
        visited[root] = true;
        if (leftChild[root] != -1 && !visited[leftChild[root]]) {
            ++moveCount;
            similarInorder(leftChild[root], last);
        } else if (rightChild[root] != -1 && !visited[rightChild[root]]) {
            ++moveCount;
            similarInorder(rightChild[root], last);
        } else if (root == last) {
            return;
        } else if (parent[root] != -1) {
            ++moveCount;
            similarInorder(parent[root], last);
        }
    }

    private static int getLast(int node) {
        if (rightChild[node] == -1) {
            return node;
        }
        return getLast(rightChild[node]);
    }
}