import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static int r, c, k;
    static char[][] matrix;
    static boolean[][] visited;

    static int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] times = new int[m+1];
        for (int i = 1; i <= m; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Member> pq = new PriorityQueue<>();
        for (int i = 1; i <= m; i++) {
            pq.add(new Member(i, i));
        }

        --n;
        while (n > s) {
            Member now = pq.poll();
            if (now.currentTime <= m) {
                // 초반 한 바퀴는 중간에 못 끼어듦
                pq.add(new Member(now.number, m + times[now.number]));
            } else {
                // 시간 순위로 나오고 시간 같으면 작은 번호부터
                pq.add(new Member(now.number, now.currentTime + times[now.number]));
            }
            --n;
        }
        System.out.println(pq.peek().number);
    }

    static class Member implements Comparable<Member> {
        public int number;
        public int currentTime;

        public Member(int number, int currentTime) {
            this.number = number;
            this.currentTime = currentTime;
        }

        @Override
        public int compareTo(Member other) {
            if (this.currentTime == other.currentTime) {
                return Integer.compare(this.number, other.number);
            }
            return Integer.compare(this.currentTime, other.currentTime);
        }
    }
}