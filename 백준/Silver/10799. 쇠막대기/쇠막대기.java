import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String brackets = br.readLine();

        int currentStick = 0;
        int sum = 0;
        int index = 0;
        while (index < brackets.length() - 1) {
            // 레이저면 현재 있는 막대 개수만큼 조각 추가
            if (brackets.charAt(index) == '(' && brackets.charAt(index + 1) == ')') {
                sum += currentStick;
                index += 2;
            // 막대 시작이면 currentStick 증가
            } else if (brackets.charAt(index) == '(') {
                ++currentStick;
                ++index;
            // 막대 끝이면 currentStick 감소, sum 1 증가
            } else {
                --currentStick;
                ++sum;
                ++index;
            }
        }
        sum += currentStick;
        System.out.println(sum);
    }
}
