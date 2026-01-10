import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isBroken = new boolean[n];
        for (int i = 0; i < b; i++) {
            int trafficLight = Integer.parseInt(br.readLine());
            isBroken[trafficLight - 1] = true;
        }

        // init
        int brokenTrafficLightCount = 0;
        for (int i = 0; i < k; i++) {
            if (isBroken[i]) {
                ++brokenTrafficLightCount;
            }
        }
        int result = brokenTrafficLightCount;
        for (int i = k; i < n; i++) {
            if (isBroken[i-k]) {
                --brokenTrafficLightCount;
            }
            if (isBroken[i]) {
                ++brokenTrafficLightCount;
            }
            result = Integer.min(result, brokenTrafficLightCount);
        }
        System.out.println(result);
    }
}