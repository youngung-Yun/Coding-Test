import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = Integer.parseInt(bf.readLine());
            // pos[상자번호] = 칸번호
            int[] pos = new int[n+2];
            // boxes[칸번호] = 상자번호
            int[] boxes = new int[n+2];
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                int number = Integer.parseInt(stk.nextToken());
                pos[number] = i;
                boxes[i] = number;
            }
            int empty = n + 1;
            pos[empty] = empty;
            boxes[empty] = empty;
            List<Integer> ans = new ArrayList<>();

            while (!sortedAll(boxes, n)) {
                // 제자리에 있지 않은 박스 하나 골라 빈 자리에 놓음
                for (int box = 1; box <= n; box++) {
                    if (boxes[box] != box) {
                        ans.add(pos[box]);
                        boxes[pos[box]] = empty;
                        int tmp = pos[box];
                        pos[box] = empty;
                        empty = tmp;
                        break;
                    }
                }
                while (empty != n + 1) {
                    int next = pos[empty];
                    ans.add(next);
                    boxes[empty] = empty;
                    empty = next;
                }
            }

            sb.append(ans.size()).append('\n');
            for (int e : ans) {
                sb.append(e).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean sortedAll(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            if (arr[i] != i) {
                return false;
            }
        }
        return true;
    }
}
