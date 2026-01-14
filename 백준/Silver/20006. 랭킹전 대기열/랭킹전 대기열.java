import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /*
         * 방은 생성 되면 리스트에 삽입
         * 방은 생성 될 때 처음 입장한 플레이어의 레벨을 받아서 레벨 컷 설정
         * 방의 최대 인원은 m명
         * 플레이어는 방 리스트를 순회하며 레벨 컷 만족 + 인원이 m명 미만이면 들어감
         * 전부 순회할 때 까지 방 못들어가면 새로 생성
         * 방은 플레이어들을 닉네임 순으로 정렬한 우선순위 큐로 구현
         * 방이 꽉 찼는지로 시작 여부 결정
         */
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player newPlayer = new Player(level, nickname);
            boolean canEnterRoom = false;
            for (Room room : rooms) {
                if (newPlayer.level >= room.lowLimit && newPlayer.level <= room.highLimit && room.personnel.size() < m) {
                    room.personnel.add(newPlayer);
                    canEnterRoom = true;
                    break;
                }
            }
            // 새로운 방 생성해서 들어감
            if (!canEnterRoom) {
                Room newRoom = new Room(newPlayer);
                rooms.add(newRoom);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.personnel.size() == m) {
                sb.append("Started!").append('\n');
            } else {
                sb.append("Waiting!").append('\n');
            }
            while (!room.personnel.isEmpty()) {
                Player player = room.personnel.poll();
                sb.append(player.level).append(' ').append(player.nickname).append('\n');
            }
        }
        System.out.println(sb);
    }

    static class Room {
        public int lowLimit;
        public int highLimit;
        public PriorityQueue<Player> personnel;

        {
            personnel = new PriorityQueue<>();
        }

        public Room(Player player) {
            this.lowLimit = Integer.max(1, player.level - 10);
            this.highLimit = player.level + 10;
            personnel.add(player);
        }
    }

    static class Player implements Comparable<Player> {
        public int level;
        public String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}