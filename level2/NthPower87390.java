import java.util.ArrayList;
import java.util.Arrays;

public class NthPower87390 {
    public static void main(String[] args) {
        NthPower87390 q = new NthPower87390();
        int n = 3;
        int left = 2;
        int right = 5;

        System.out.println(Arrays.toString(q.solution(n, left, right)));
    }

    public int[] solution(int n, int left, int right) {
        int[] answer = new int[n*n];
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[n][n];

        int tmp = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i+1; j++) {
                arr[i][j] = tmp;
                System.out.println("i = " + i + " / j : " + j);
                if (i == j) {
                    tmp++;
                } else if (i <= j)
                answer[idx] = arr[i][j];
                if (idx >= left && idx <= right) {
                    list.add(answer[idx]);
                }
                idx++;
            }
        }

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
