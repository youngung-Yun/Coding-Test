import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            sb.append('#').append(testCase).append(' ');
            String[] words = new String[5];
            for (int i = 0; i < 5; i++) {
                words[i] = br.readLine();
            }
            for (int i = 0; i < 15; i++) {
                for (String word : words) {
                    if (i < word.length()) {
                        sb.append(word.charAt(i));
                    }
                }
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static int getMod(int n, int mod) {
        int result = n % mod;
        if (result == 0) {
            return mod;
        } else {
            return result;
        }
    }
}