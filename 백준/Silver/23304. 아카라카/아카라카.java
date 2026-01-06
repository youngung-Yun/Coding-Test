import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(recursion(str) ? "AKARAKA" : "IPSELENTI");
    }

    private static boolean recursion(String str) {
        if (str.length() == 1) {
            return true;
        }
        // 자신이 펠린드롬인지 확인
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        if (str.length() % 2 == 0) {
            return recursion(str.substring(0, str.length() / 2)) && recursion(str.substring(str.length() / 2));
        } else {
            return recursion(str.substring(0, str.length() / 2)) && recursion(str.substring(str.length() / 2 + 1));
        }
    }
}