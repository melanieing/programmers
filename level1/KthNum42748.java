import java.util.Arrays;

/**
 * 42748. K번째수
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return
 */
public class KthNum42748 {
    public static void main(String[] args) {
        KthNum42748 q = new KthNum42748();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        System.out.println(Arrays.toString(q.solution(array, commands)));

    }

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int n = 0;

        for (int[] command : commands) {
            // 1. 범위만큼 자르기
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] tmp = new int[j-i+1];
            int idx = 0;
            for (int a = i-1; a < j; a++) {
                tmp[idx++] = array[a];
            }
            // 2. 정렬
            Arrays.sort(tmp);

            // 3. 원하는 인덱스의 값 추출
            answer[n++] = tmp[k-1];
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] temp = new int[j - i + 1];
            int cnt = 0;
            for (int b = i-1; b <= j-1; b++) {
                temp[cnt++] = array[b];
            }
            Arrays.sort(temp);
            answer[a] = temp[k-1];
        }

        return answer;
    }
}
