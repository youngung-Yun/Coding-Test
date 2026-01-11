import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            String paper = br.readLine();
            if (recursion(paper, 0, paper.length() - 1)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean recursion(String paper, int start, int end) {
        if (start == end) {
            return true;
        }
        int length = end - start;
        for (int i = 0; i <  length / 2; i++) {
            if (paper.charAt(start + i) == paper.charAt(end - i)) {
                return false;
            }
        }
        int center = start + (length / 2);
        return recursion(paper, start, center - 1) && recursion(paper, center + 1, end);
    }
}