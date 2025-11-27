import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int k = 0; k < n; k++) {
                String[] cloth = br.readLine().split(" ");
                String typeOfCloth = cloth[1];
                map.put(typeOfCloth, map.getOrDefault(typeOfCloth, 0) + 1);
            }

            int totalCase = 1;
            for (int count : map.values()) {
                totalCase *= count + 1;
            }
            
            sb.append(--totalCase).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
