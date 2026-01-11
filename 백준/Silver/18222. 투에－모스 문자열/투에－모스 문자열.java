import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long length = 1L;
        while (length < k) {
            length *= 2L;
        }
        System.out.println(recursion(k, length));
    }

    static int recursion(long pos, long length) {
        if (length == 1L) {
            return 0;
        }
        long half = length / 2L;
        // 현재 위치가 왼쪽이면 이전 문자열의 해당 위치의 값과 동일함
        if (pos <= length / 2L) {
            return recursion(pos, half);
        } else {
        // 현재 위치가 오른쪽이면 이전 문자열에서 같은 위치인 값을 뒤집은 값
            return (recursion(pos - half, half) + 1) % 2;
        }
    }
}