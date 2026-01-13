import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            City[] cities = new City[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                cities[i] = new City(i, x, y, power);
            }

            // 항복 상태 나타낼 배열
            int[] tree = new int[n];
            for (int i = 0; i < n; i++) {
                tree[i] = i;
            }

            char[] result = new char[n];

            sb.append('#').append(t).append(' ');

            for (int i = 0; i < n; i++) {
                City currentCity = cities[i];
                // 현재 가장 큰 영향력을 행사하는 도시
                Leverage maxLeverage = null;
                int maxLeverageCount = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    // 1. 도시 a가 도시 b에게 행사하는 영향력 = power(a) / (x(b) - x(a))^2 + (y(b) - y(a))^2
                    // 2. 어떤 도시가 행사하는 영향력이 당하는 도시의 군사력보다 크다면 그 도시는 위협받음
                    // 3. 어떤 도시가 어떠한 다른 도시에도 위협당하지 않으면 군주제 (K)
                    // 4. 어떤 도시가 하나 이상의 도시에게 위협당하며 영향력이 최대인 도시가 유일하면, 그 도시에 항복함. 그 도시 또한 항복했으면 연쇄적으로 작용
                    // 5. 어떤 도시가 하나의 이상의 도시에게 위협당하며 영향력이 최대인 도시가 둘 이상이면 공화제 (D)
                    City otherCity = cities[j];
                    Leverage currentLeverage = new Leverage(j, otherCity.power,
                            (currentCity.x - otherCity.x) * (currentCity.x - otherCity.x) + (currentCity.y - otherCity.y) * (currentCity.y - otherCity.y));
                    // 영향력이 군사력보다 작거나 같으면 넘어감
                    if (currentCity.power * currentLeverage.denominator >= currentLeverage.numerator) {
                        continue;
                    }

                    if (maxLeverageCount == 0) {
                        maxLeverage = currentLeverage;
                        ++maxLeverageCount;
                        continue;
                    }
                    int maxLeveragePower = maxLeverage.numerator * currentLeverage.denominator;
                    int currentLeveragePower = currentLeverage.numerator * maxLeverage.denominator;
                    // 가장 큰 영향력 도시 변경
                    if (maxLeveragePower < currentLeveragePower) {
                        maxLeverage = currentLeverage;
                        maxLeverageCount = 1;
                        // 영향력이 같음
                    } else if (maxLeveragePower == currentLeveragePower) {
                        ++maxLeverageCount;
                    }
                }
                if (maxLeverageCount == 0) {
                    result[i] = 'K';
                } else if (maxLeverageCount == 1) {
                    result[i] = 'S';
                    tree[i] = maxLeverage.number;
                } else {
                    result[i] = 'D';
                }
            }
            for (int i = 0; i < n; i++) {
                char ch = result[i];
                if (ch == 'K') {
                    sb.append("K ");
                } else if (ch == 'S') {
                    sb.append(findRoot(tree, i) + 1).append(' ');
                } else {
                    sb.append("D ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class City {
        public int number;
        public int x;
        public int y;
        public int power;

        public City(int number, int x, int y, int power) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    static class Leverage {
        public int number;
        public int numerator;
        public int denominator;

        public Leverage(int number, int numerator, int denominator) {
            this.number = number;
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    static int findRoot(int[] array, int x) {
        int i = x;
        while (array[i] != i) {
            i = array[i];
        }
        return i;
    }
}