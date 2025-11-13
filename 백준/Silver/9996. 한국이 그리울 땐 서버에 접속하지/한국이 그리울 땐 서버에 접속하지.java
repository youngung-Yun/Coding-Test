import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String pattern = br.readLine();
        int indexOfAsterisk = pattern.indexOf('*');
        String start = pattern.substring(0, indexOfAsterisk);
        String end = pattern.substring(indexOfAsterisk + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String filename = br.readLine();

            if (filename.startsWith(start) && filename.endsWith(end) && start.length() <= filename.lastIndexOf(end)) {
                sb.append("DA").append('\n');
            } else {
                sb.append("NE").append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}