import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] depth = new int[1024];
        depth[1] = 0;
        int[][] binaryParents = new int[1024][5];
        binaryParents[1][0] = -1;
        // 부모 노드 저장 및 깊이 저장
        for (int i = 2; i < 1024; i++) {
            binaryParents[i][0] = i / 2;
            depth[i] = depth[i/2] + 1;
        }
        // i의 2*k번째 부모
        for (int i = 1; i < 1024; i++) {
            for (int k = 1; k < 5; k++) {
                int mid = binaryParents[i][k-1];
                if (mid == -1) {
                    binaryParents[i][k] = -1;
                } else {
                    binaryParents[i][k] = binaryParents[mid][k-1];
                }
            }
        }

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 깊이 맞추기
            int diff = Math.abs(depth[a] - depth[b]);
            if (depth[a] > depth[b]) {
                for (int i = 4; i >= 0; i--) {
                    if ((diff & (0b1 << i)) != 0) {
                        a = binaryParents[a][i];
                    }
                }
            } else if (depth[a] < depth[b]) {
                for (int i = 4; i >= 0; i--) {
                    if ((diff & (0b1 << i)) != 0) {
                        b = binaryParents[b][i];
                    }
                }
            }
            if (a == b) {
                sb.append(a * 10).append('\n');
                continue;
            }
            for (int i = 3; i >= 0; --i) {
                if (binaryParents[a][i] != binaryParents[b][i]) {
                    a = binaryParents[a][i];
                    b = binaryParents[b][i];
                }
            }
            sb.append(binaryParents[a][0] * 10).append('\n');
        }
        System.out.println(sb);
    }
}