import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines[i] = new Line(start, end);
        }
        Arrays.sort(lines);
        int start = -1_000_000_000;
        int end = -1_000_000_000;
        long total = 0L;
        for (Line line : lines) {
            // 이전 선과 겹치거나 딱 맞으면 end 연장
            if (end >= line.start) {
                end = Integer.max(end, line.end);
            } else {
                // 겹치지 않으면 총 길이 더하고 start와 end 갱신
                total += (end - start);
                start = line.start;
                end = line.end;
            }
        }
        total += (end - start);
        System.out.println(total);
    }

    static class Line implements Comparable<Line> {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.start, o.start);
        }
    }
}