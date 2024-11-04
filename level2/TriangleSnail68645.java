import java.util.Arrays;
// 68645. 삼각 달팽이
public class TriangleSnail68645 {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static void main(String[] args) {
        int n = 4;

        TriangleSnail68645 q = new TriangleSnail68645();
        System.out.println(Arrays.toString(q.solution2(n)));
    }

    public int[] solution2(int n) {
        // 1. n * n 2차원 배열, 채워넣을 숫자 선언
        int[][] triangle = new int[n][n];
        int v = 1;
        // 2. 숫자를 채울 현재 위치를 (0, 0)으로 설정, 방향 키 d 설정
        int x = 0, y = 0, d = 0;

        // 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 더 이상 진행할 수 없을 때는 방향을 전환하기
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3; // 2를 넘어가면 다시 0으로 돌아오도록 하기
                nx = x + dx[d];
                ny = y + dy[d];
                // 전환된 방향으로도 진행을 못하는 경우 숫자 채우기 종료
                if (nx == n|| ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        // 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
        int[] result = new int[v-1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<= i; j++) {
                result[idx++] = triangle[i][j];
            }
        }

        return result;
    }

    public int[] solution1(int n) {
        // 1. n * n 2차원 배열, 채워넣을 숫자 선언
        int[][] triangle = new int[n][n];
        int v = 1;

        // 2. 숫자를 채울 현재 위치를 (0, 0)으로 설정
        int x = 0, y = 0;

        // 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
        while (true) {
            // A. 아래로 이동하면서 숫자 채우기
            while (true) {
                triangle[y][x] = v++;
                if (y + 1 == n || triangle[y+1][x] != 0) { // 더 이상 아래로 이동할 수 없으면 빠져나오기
                    break;
                }
                y++;
            }
            if (x + 1 == n || triangle[y][x+1] != 0) { // 더 이상 오른쪽으로 이동할 수 없으면 빠져나오기
                break;
            }
            x++;

            // B. 오른쪽으로 이동하면서 숫자 채우기
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x+1] != 0) { // 더 이상 아래로 이동할 수 없으면 빠져나오기
                    break;
                }
                x++;
            }
            if (triangle[y-1][x-1] != 0) { // 더 이상 위로 이동할 수 없으면 빠져나오기
                break;
            }
            x--;
            y--;

            // C. 왼쪽위로 이동하면서 숫자 채우기
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y-1][x-1] != 0) { // 더 이상 왼쪽으로 이동할 수 없으면 빠져나오기
                    break;
                }
                x--;
                y--;
            }
            if (y + 1 == n || triangle[y+1][x] != 0) { // 더 이상 오른쪽으로 이동할 수 없으면 빠져나오기
                break;
            }
            y++;
        }

        // 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
        int[] result = new int[v-1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<= i; j++) {
                result[idx++] = triangle[i][j];
            }
        }

        return result;
    }
}
