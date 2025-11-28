import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int sum = 0;
        int[] counting = new int[10];
        for (char ch : number.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            sum += digit;
            ++counting[digit];
        }
        
        StringBuilder sb = new StringBuilder();
        if (counting[0] == 0 || sum % 3 != 0) {
            sb.append(-1);
        } else {
            int curr = 9;
            while (curr >= 0) {
                if (counting[curr] > 0) {
                    sb.append(curr);
                    --counting[curr];
                } else {
                    --curr;
                }
            }
        }
        System.out.println(sb.toString());
    }
}