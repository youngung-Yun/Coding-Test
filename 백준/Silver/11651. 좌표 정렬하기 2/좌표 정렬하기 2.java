import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new Point(br.readLine().split(" ")));
        }
        Collections.sort(list);
        for (Point p : list) {
            sb.append(p.toString()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static class Point implements Comparable<Point>{
        public int x;
        public int y;

        public Point(String[] temp) {
            x = Integer.parseInt(temp[0]);
            y = Integer.parseInt(temp[1]);
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y) {
                return Integer.compare(this.x, o.x);
            }
            else {
                return Integer.compare(this.y, o.y);
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}