import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);
            int[] array;
            if (input.isBlank()) {
                array = new int[0];
            } else {
                array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            }
            int leftIdx = 0;
            int rightIdx = array.length;
            boolean isReversed = false;
            for (char ch : func.toCharArray()) {
                if (leftIdx > rightIdx) {
                    break;
                }

                if (ch == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (!isReversed) {
                        ++leftIdx;
                    } else {
                        --rightIdx;
                    }
                }
            }
            if (leftIdx > rightIdx) {
                sb.append("error").append('\n');
            } else {
                sb.append("[");
                if (!isReversed) {
                    for (int i = leftIdx; i < rightIdx; i++) {
                        int e = array[i];
                        sb.append(e).append(",");
                    }
                } else {
                    for (int i = rightIdx - 1; i >= leftIdx; i--) {
                        int e = array[i];
                        sb.append(e).append(",");
                    }
                }
                if (leftIdx < rightIdx) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}

