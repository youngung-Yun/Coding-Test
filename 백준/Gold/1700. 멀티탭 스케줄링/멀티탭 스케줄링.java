import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int INF = 101;

    static int plug;
    static int use;
    static int[] electronics;
    static Set<Integer> multitap;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(bf.readLine());

        plug = Integer.parseInt(stk.nextToken());
        use = Integer.parseInt(stk.nextToken());
        electronics = new int[use];
        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < use; i++) {
            electronics[i] = Integer.parseInt(stk.nextToken());
        }

        int ans = 0;
        multitap = new HashSet<>();
        for (int i = 0; i < use; i++) {
            int electronic = electronics[i];
            if (multitap.size() < plug || multitap.contains(electronic)) {
                multitap.add(electronic);
                continue;
            }
            ++ans;
            // 멀티탭 다 찼으면 현재 꽂혀있는 제품 중 가장 나중에 사용될 제품 제거
            int latest = findLatest(i);
            multitap.remove(latest);
            multitap.add(electronic);
        }
        System.out.println(ans);
    }

    static int findLatest(int now) {
        int result = -1;
        int lastIdx = -1;
        for (int e : multitap) {
            int nextUse = INF;
            for (int i = now + 1; i < use; i++) {
                if (electronics[i] == e) {
                    nextUse = i;
                    break;
                }
            }

            if (nextUse > lastIdx) {
                lastIdx = nextUse;
                result = e;
            }

            if (lastIdx == INF) {
                return result;
            }
        }
        return result;
    }
}