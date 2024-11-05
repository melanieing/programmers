import java.util.Arrays;
// 12949. 행렬의 곱셈
public class MatrixMultiply_12949 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        MatrixMultiply_12949 q = new MatrixMultiply_12949();
        System.out.println(Arrays.deepToString(q.solution(arr1, arr2)));

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length]; // 행렬의 곱은 arr1의 행 * arr2의 열

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
