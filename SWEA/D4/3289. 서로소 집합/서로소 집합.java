import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Solution {

    static int[] disjointSet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            StringBuilder result = new StringBuilder();
            disjointSet = IntStream.rangeClosed(0, n).toArray();
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(token.nextToken());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                if (command == 0) {
                    union(a, b);
                } else {
                    if (find(a) == find(b)) {
                        result.append(1);
                    } else {
                        result.append(0);
                    }
                }
            }

            sb.append('#').append(testCase).append(' ').append(result.toString()).append('\n');
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (x != disjointSet[x]) {
            disjointSet[x] = find(disjointSet[x]);
        }
        return disjointSet[x];
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        int min = Integer.min(parentX, parentY);
        int max = Integer.max(parentX, parentY);
        disjointSet[max] = min;
    }
}