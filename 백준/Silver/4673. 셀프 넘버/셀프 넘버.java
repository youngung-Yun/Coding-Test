public class Main {
    public static void main(String[] args) throws Exception {

        boolean[] b = new boolean[15_000];

        for (int i = 1; i <= 10_000; i++) {
            int n = d(i);
            while (n <= 10_000) {
                b[n] = true;
                n = d(n);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10_000; i++) {
            if (!b[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static int d(int n) {
        int result = n;
        String str = String.valueOf(n);
        for (char digit : str.toCharArray()) {
            result += Character.getNumericValue(digit);
        }
        return result;
    }
}