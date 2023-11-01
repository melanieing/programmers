import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 172928. 공원 산책
 * 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return
 */
public class ParkWalk172928 {
    public static void main(String[] args) {
        ParkWalk172928 q = new ParkWalk172928();
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        System.out.println(Arrays.toString(q.solution(park, routes)));
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        ArrayList<Point> banned = new ArrayList<>();
        Point start = null;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'X') {
                    banned.add(new Point(i, j)); // 못 가는 곳
                } else if (park[i].charAt(j) == 'S') {
                    start = new Point(i, j); // 시작 지점 체크
                }
            }
        }

        for (String route : routes) {
            char op = route.charAt(0);                                  // 방향
            int n = Integer.parseInt(String.valueOf(route.charAt(2)));  // 거리
            Point tmp = new Point(start.x, start.y);
            boolean flag = true;        // 갈 수 있다면 true
            for (int i = 0; i < n; i++) {
                if (op == 'N') {        // 북쪽으로 이동
                    tmp.x -= 1;
                } else if (op == 'S') { // 남쪽으로 이동
                    tmp.x += 1;
                } else if (op == 'W') { // 서쪽으로 이동
                    tmp.y -= 1;
                } else if (op == 'E') { // 동쪽으로 이동
                    tmp.y += 1;
                }
                if (banned.contains(tmp) || tmp.x >= park.length || tmp.x < 0 || tmp.y >= park[0].length() || tmp.y < 0) { // 범위를 벗어나면
                    flag = false; // 갈 수 없으므로 false
                    tmp = start; // 처음으로 위치 돌려놓고 멈추기
                    break;
                }
            }
            if (flag) start = tmp; // 갈 수 있는 곳이면 시작지점 업데이트
        }

        answer[0] = start.x;
        answer[1] = start.y;

        return answer;
    }
}
