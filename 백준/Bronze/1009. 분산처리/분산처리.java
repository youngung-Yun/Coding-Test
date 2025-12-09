import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
            }

            sb.append(result == 0 ? 10 : result).append('\n');
        }

        System.out.println(sb.toString());
    }

}