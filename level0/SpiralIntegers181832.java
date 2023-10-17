import java.util.Arrays;

/**
 * 181832. 정수를 나선형으로 배치하기
 * n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return
 */
public class SpiralIntegers181832 {
    public static void main(String[] args) {
        SpiralIntegers181832 q = new SpiralIntegers181832();
        int n = 4;

        System.out.println(Arrays.deepToString(q.solution(n)));
    }

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 1;          // 채워야 할 값
        int row = 0;            // 현재 행 위치
        int col = 0;            // 현재 열 위치
        int direction = 0;      // 이동 방향 (0:오른쪽, 1:아래, 2:왼쪽, 3:위쪽)

        while (value <= n * n) {
            answer[row][col] = value++;

            if (direction == 0) { // 오른쪽으로 이동
                if (col == n - 1 || answer[row][col + 1] != 0) { // 우측끝에 닿았거나 이미 채운 자리일 경우
                    direction = 1;
                    row++;
                } else {
                    col++;
                }
            } else if (direction == 1) { // 아래로 이동
                if (row == n - 1 || answer[row + 1][col] != 0) { // 맨 아래에 닿았거나 이미 채운 자리일 경우
                    direction = 2;
                    col--;
                } else {
                    row++;
                }
            } else if (direction == 2) { // 왼쪽으로 이동
                if (col == 0 || answer[row][col - 1] != 0) { // 좌측끝에 닿았거나 이미 채운 자리일 경우
                    direction = 3;
                    row--;
                } else {
                    col--;
                }
            } else if (direction == 3) { // 위로 이동
                if (row == 0 || answer[row - 1][col] != 0) { // 맨 위에 닿았거나 이미 채운 자리일 경우
                    direction = 0;
                    col++;
                } else {
                    row--;
                }
            }
        }

        return answer;
    }
}
