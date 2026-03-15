import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] cranes = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(cranes);

        int m = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        int[] boxes = new int[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(boxes);

        if (cranes[n-1] < boxes[m-1]) {
            System.out.println(-1);
            return;
        }

        int[] nextBox = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
           while (curr < m && boxes[curr] <= cranes[i]) {
               ++curr;
           }
           nextBox[i] = curr - 1;
        }

        int remainCount = m;
        int time = 0;
        boolean[] loaded = new boolean[m];
        while (remainCount > 0) {
            ++time;
            for (int i = n -1; i >= 0; i--) {
                while (nextBox[i] >= 0 && loaded[nextBox[i]]) {
                    --nextBox[i];
                }
                if (nextBox[i] < 0) {
                    continue;
                }
                loaded[nextBox[i]] = true;
                --remainCount;
            }
        }
        System.out.println(time);
    }
}