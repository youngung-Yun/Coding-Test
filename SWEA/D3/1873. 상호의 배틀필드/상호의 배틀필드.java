/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int h = sc.nextInt(), w = sc.nextInt();
            int[][] field = new int[h][w];

            int nx = 0;
            int ny = 0;
            for (int i = 0; i < h; i++) {
                String row = sc.next();
                for (int j = 0; j < w; j++) {
                    char ch = row.charAt(j);
                    field[i][j] = ch;
                    if (ch == '^' || ch == 'v' || ch == '<' || ch == '>') {
                        nx = i;
                        ny = j;
                    }
                }
            }

            /*
            U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
            D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
            L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
            R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
            S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

            /*
            .	평지(전차가 들어갈 수 있다.)
            *	벽돌로 만들어진 벽
            #	강철로 만들어진 벽
            -	물(전차는 들어갈 수 없다.)
            ^	위쪽을 바라보는 전차(아래는 평지이다.)
            v	아래쪽을 바라보는 전차(아래는 평지이다.)
            <	왼쪽을 바라보는 전차(아래는 평지이다.)
            >	오른쪽을 바라보는 전차(아래는 평지이다.)
             */

            /*
            전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.

            전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.

            만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.

            강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.

            게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.
             */

            Map<Character, int[]> map = new HashMap<>();
            map.put('U', new int[] {-1, 0});
            map.put('D', new int[] {1, 0});
            map.put('L', new int[] {0, -1});
            map.put('R', new int[] {0, 1});
            map.put('^', new int[] {-1, 0});
            map.put('v', new int[] {1, 0});
            map.put('<', new int[] {0, -1});
            map.put('>', new int[] {0, 1});

            Map<Character, Character> tankMap = new HashMap<>();
            tankMap.put('U', '^');
            tankMap.put('D', 'v');
            tankMap.put('L', '<');
            tankMap.put('R', '>');


            int n = sc.nextInt();
            String commands = sc.next();

            for (char command: commands.toCharArray()) {
                if (map.containsKey(command)) {
                    char direction = command;
                    char tank = tankMap.get(direction);
                    int[] d = map.get(command);
                    int dx = nx + d[0];
                    int dy = ny + d[1];
                    // 범위 밖이면 이동하지 않음
                    if (dx < 0 || dy < 0 || dx >= h || dy >= w) {
                        field[nx][ny] = tank;
                        continue;
                    }
                    // 평지가 아니면 이동하지 않음
                    if (field[dx][dy] != '.') {
                        field[nx][ny] = tank;
                        continue;
                    }
                    // 이동
                    field[dx][dy] = tank;
                    field[nx][ny] = '.';
                    nx = dx;
                    ny = dy;
                } else { // 사격
                    int[] d = map.get((char) field[nx][ny]);
                    int dx = nx + d[0];
                    int dy = ny + d[1];
                    while (true) {
                        // 범위 밖으로 나가면 종료
                        if (dx < 0 || dy < 0 || dx >= h || dy >= w) {
                            break;
                        }
                        // 강철 벽에 부딪히면 아무 일도 없음
                        if (field[dx][dy] == '#') {
                            break;
                        }
                        // 벽돌 벽에 부딪히면 평지로 만들고 종료
                        if (field[dx][dy] == '*') {
                            field[dx][dy] = '.';
                            break;
                        }
                        dx += d[0];
                        dy += d[1];
                    }
                }
            }

            System.out.printf("#%d ", test_case);
            for (int row = 0; row < h; ++row) {
                for (int col = 0; col < w; ++col) {
                    System.out.printf("%c", field[row][col]);
                }
                System.out.println();
            }
        }
    }
}