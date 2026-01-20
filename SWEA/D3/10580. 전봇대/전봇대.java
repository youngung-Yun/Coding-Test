import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            Fiber[] fibers = new Fiber[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                fibers[i] = new Fiber(a, b);
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i == k) {
                        continue;
                    }
                    Fiber current = fibers[i];
                    Fiber other = fibers[k];
                    if ((current.start >= other.start && current.end >= other.end) ||
                        (current.start <= other.start && current.end <= other.end)) {
                        continue;
                    }
                    ++answer;
                }
            }
            answer /= 2;
            sb.append('#').append(testCase).append(' ').append(answer).append('\n');
        };
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

    static class Fiber {
        public int start;
        public int end;

        public Fiber(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}