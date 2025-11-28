import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        for (String card : inputs) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for (String card : cards) {
            sb.append(map.getOrDefault(card, 0)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}   