import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static long[] segmentTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        segmentTree = new long[4 * n];
        buildSegmentTree(array, 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            long c = Long.parseLong(token.nextToken());
            if (a == 1) {
                update(1, 0, n - 1, b - 1, c);
            } else {
                long sum = query(1, 0, n - 1, b - 1, ((int) c) - 1);
                sb.append(sum).append('\n');
            }
        }
        System.out.println(sb);
    }

    /**
     *
     * @param array 원본 배열
     * @param curr 트리상의 현재 노드 번호
     * @param start 현재 노드가 담당하는 부분의 시작
     * @param end 현재 노드가 담당하는 부분의 끝
     */
    static void buildSegmentTree(long[] array, int curr, int start, int end) {
        // 리프 노드면 값 그대로 넣음
        if (start == end) {
            segmentTree[curr] = array[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildSegmentTree(array, curr * 2, start, mid);
        buildSegmentTree(array, curr * 2 + 1, mid + 1, end);
        segmentTree[curr] = segmentTree[curr * 2] + segmentTree[curr * 2 + 1];
    }

    /**
     *
     * @param curr 트리상의 현재 노드 번호
     * @param start 현재 노드가 담당하는 부분의 시작
     * @param end 현재 노드가 담당하는 부분의 끝
     * @param left 쿼리할 부분의 시작
     * @param right 쿼리할 부분의 끝
     * @return 구간 합
     */
    static long query(int curr, int start, int end, int left, int right) {
        // 범위 밖으로 벗어남
        if (start > right || end < left) {
            return 0L;
        }
        // 완전히 포함하면 더 내려갈 필요 없음
        if (start >= left && end <= right) {
            return segmentTree[curr];
        }
        int mid = start + (end - start) / 2;

        return query(curr * 2, start, mid, left, right) + query(curr * 2 + 1, mid + 1, end, left, right);
    }

    /**
     *
     * @param curr 트리상의 현재 노드 번호
     * @param start 현재 노드가 담당하는 부분의 시작
     * @param end 현재 노드가 담당하는 부분의 끝
     * @param index 값을 변경할 위치
     * @param newValue 새로 변경할 값
     */
    static void update(int curr, int start, int end, int index, long newValue) {
        // 해당 인덱스 도착하면 값 변경
        if (start == end) {
            segmentTree[curr] = newValue;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            // 왼쪽 자식으로
            update(curr * 2, start, mid, index, newValue);
        } else {
            // 오른쪽 자식으로
            update(curr * 2 + 1, mid + 1, end, index, newValue);
        }
        // 다시 위로 올라가며 값 수정
        segmentTree[curr] = segmentTree[curr * 2] + segmentTree[curr * 2 + 1];
    }
}