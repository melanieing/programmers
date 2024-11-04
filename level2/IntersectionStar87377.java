import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 87377. 교점에 별 만들기
public class IntersectionStar87377 {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        IntersectionStar87377 q = new IntersectionStar87377();
        System.out.println(Arrays.toString(q.solution(line)));

    }

    public String[] solution(int[][] line) {

        List<Point> points = new ArrayList<>();
        // 1. 모든 직선 쌍에 대해 반복
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j< line.length; j++) {
                // A. 교점 좌표 구하기
                Point intersection = getIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                // B. 정수 좌표만 저장
                if (intersection != null) points.add(intersection);
            }
        }

        // 2. 저장된 정수들에 대해 x, y좌표의 최댓값, 최솟값 구하기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        // 3. 구한 최댓값, 최솟값을 이용해 2차원 배열의 크기 결정
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 2차원 배열에 별 표시
        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int )(maximum.y - p.y);
            arr[y][x] = '*';
        }

        // 5. 문자열 배열로 변환 후 반환
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        // 가장 작은 좌표 찾기
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        // 가장 큰 좌표 찾기
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double)(b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double)(a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 정수가 아니면 반환X
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long)x, (long)y);
    }

    public static class Point { // 데이터를 나타내는 클래스
        // final : 불변성
        // 좌표범위가 주어지지 않았기 때문에 long 타입
        public final long x, y;

        private Point(long x, long y) { // 생성자로만 초기화 가능
            this.x = x;
            this.y = y;
        }
    }

}
