import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int highest = 0;
        int[] pillars = new int[1_001];
        int width = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            highest = Math.max(highest, h);
            pillars[l] = h;
            width = Math.max(width, l);
        }
        int highestMinIdx = 1_002;
        int highestMaxIdx = 0;
        for (int i = 0; i <= width; i++) {
            if (pillars[i] == highest) {
                highestMinIdx = Math.min(highestMinIdx, i);
                highestMaxIdx = Math.max(highestMaxIdx, i);
            }
        }
        int area = 0;

        int currentHeight = 0;
        for (int i = 0; i < highestMinIdx; i++) {
            currentHeight = Math.max(currentHeight, pillars[i]);
            area += currentHeight;
        }
        currentHeight = 0;
        for (int i = width; i >= highestMaxIdx; i--) {
            currentHeight = Math.max(currentHeight, pillars[i]);
            area += currentHeight;
        }

        area += (highestMaxIdx - highestMinIdx) * highest;

        System.out.println(area);
    }

}