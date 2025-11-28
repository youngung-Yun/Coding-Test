import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 마지막에 홀인 사람이 이김
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}