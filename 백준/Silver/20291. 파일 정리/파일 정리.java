import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            int idx = file.indexOf('.');
            String extension = file.substring(idx + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String extension : map.keySet()) {
            sb.append(extension).append(' ').append(map.get(extension)).append('\n');
        }

        System.out.println(sb.toString());
    }
}