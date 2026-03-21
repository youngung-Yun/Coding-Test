import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bf.readLine());

        System.out.println(n % 2L == 0L ? "CY" : "SK");
    }
}