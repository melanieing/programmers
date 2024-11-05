import java.util.Arrays;
// 81302. 거리두기 확인하기
public class Distancing81302 {

    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) {
        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Distancing81302 q = new Distancing81302();
        System.out.println(Arrays.toString(q.solution(places)));
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 1. 대기실의 모든 응시자 위치에 대해 반복
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 2. 모든 응시자의 위치를 검사했으나 거리두기를 지키지 않은 경우를 발견하지 못했으면 거리두기를 지킨 것
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 해당 대기실이 거리두기를 지키고 있는지 검사
    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    // 해당 대기실에서 (x,y) 위치의 응시자가 거리두기를 지키고 있는지 검사
    private boolean isDistanced(char[][] room, int x, int y) {
        // A. 상하좌우 중 빈 테이블이 있는 방향에 대해 B로 진행
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]) {
                // 응시자 -> 맨해튼 거리 1에 다른 응시자가 있는 것이므로 거리두기가 지켜지지 않은 것
                case 'P' -> {
                    return false;
                }
                // B. 빈 테이블과 인접한 위치 중 응시자가 있다면 거리두기를 지키지 않은 것
                case 'O'-> {
                    // 원래 검사를 시작했던 응시자는 제외
                    if (isNextToVoluteer(room, nx, ny, 3 - d)) return false;
                }
            }
        }
        return true;
    }

    // exclude 방향을 제외한 네 방향에 다른 응시자가 있는지 검사
    private boolean isNextToVoluteer(char[][] room, int x, int y, int exlude) {
        for (int d = 0; d < 4; d++) {
            if (d == exlude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
}
