class Solution {
    public int solution(int n, int k) {
        String str = Integer.toString(n, k);
        String[] numbers = str.split("0");
        int count = 0;
        for (String number : numbers) {
            System.out.println(number);
            if (number.isBlank()) {
                continue;
            }
            count += isPrimeNumber(Long.parseLong(number)) ? 1 : 0;                
        }
        return count;
    }
    
    private static boolean isPrimeNumber(long n) {
        if (n <= 1L) {
            return false;
        } else if (n == 2L) {
            return true;
        }
        for (long i = 2L; i <= (long) Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0L) {
                return false;
            }
        }
        return true;
    }
}