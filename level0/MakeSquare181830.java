import java.util.Arrays;

/**
 * 181830. 정사각형으로 만들기
 * arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고,
 * 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록
 * 각 열의 끝에 0을 추가한 이차원 배열을 return
 */
public class MakeSquare181830 {
    public static void main(String[] args) {
        MakeSquare181830 q = new MakeSquare181830();
        int[][] arr = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};

        System.out.println(Arrays.deepToString(q.solution(arr)));
    }

    public int[][] solution(int[][] arr) {
        int width = arr.length;
        int height = arr[0].length;
        int[][] answer;

        if (width > height) {
            answer = new int[width][width];
        } else if (width < height) {
            answer = new int[height][height];
        } else {
            return arr;
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (i >= arr.length || j >= arr[i].length) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = arr[i][j];
                }
            }
        }

        return answer;
    }
}
