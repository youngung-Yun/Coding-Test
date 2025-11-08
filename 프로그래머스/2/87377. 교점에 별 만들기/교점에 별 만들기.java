import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> dots = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int k = i + 1; k < line.length; k++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[k][0];
                long D = line[k][1];
                long E = line[i][2];
                long F = line[k][2];
                
                long denominator = A * D - B * C;
                if (denominator == 0) {
                    continue;
                }
                
                double x = (B * F - E * D) / (double) denominator;
                double y = (E * C - A * F) / (double) denominator;
                
                if (x % 1.0 != 0.0 || y % 1.0 != 0.0) {
                    continue;
                }
                dots.add(new long[]{(long) x, (long) y});
            }
        }
        
        long minX = dots.get(0)[0];
        long maxX = dots.get(0)[0];
        long minY = dots.get(0)[1];
        long maxY = dots.get(0)[1];
        
        for (long[] dot : dots) {
            minX = Math.min(minX, dot[0]); 
            maxX = Math.max(maxX, dot[0]); 
            minY = Math.min(minY, dot[1]); 
            maxY = Math.max(maxY, dot[1]); 
        }
        
        long deltaX = maxX - minX;
        long deltaY = maxY - minY;
        
        char[][] charArray = new char[(int) deltaY + 1][(int) deltaX + 1];
        for (char[] row : charArray) {
            Arrays.fill(row, '.');
        }
        
        for (long[] dot : dots) {
            charArray[(int) dot[1] - (int) minY][(int) dot[0] - (int) minX] = '*';
        }
                
        String[] result = new String[(int) deltaY + 1];
        for (int i = 0; i < (int) deltaY + 1; i++) {
            result[(int) deltaY - i] = new String(charArray[i]);
        }

        return result;
    }
}