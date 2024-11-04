import java.util.Arrays;
// 81302. 거리두기 확인하기
public class Distancing81302 {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

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
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 거리두기 검사 후 answer에 기록
            System.out.println(Arrays.deepToString(room));
        }


        // 1. 대기실의 모든 응시자 위치에 대해 반복
        // A. 상하좌우 중 빈 테이블이 있는 방향에 대해 B로 진행

        // B. 빈 테이블과 인접한 위치 중 응시자가 있다면 거리두기를 지키지 않은 것

        // 2. 모든 응시자의 위치를 검사했으나 거리두기를 지키지 않은 경우를 발견하지 못했으면 거리두기를 지킨 것

        return answer;
    }

    private boolean isDistanced(char[][] room) {
        // 거리두기 검사

        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        // 거리두기 검사

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
