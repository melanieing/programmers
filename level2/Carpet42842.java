import java.util.Arrays;

/**
 * 42842. 카펫
 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
 */
public class Carpet42842 {
    public static void main(String[] args) {
        Carpet42842 q = new Carpet42842();
        int brown = 10;
        int yellow = 2;

        System.out.println(Arrays.toString(q.solution(brown, yellow)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            for (int j = 1; j <= yellow; j++) {
                if (i >= j && i * j == yellow) {
                    if (brown == (i * 2 + j * 2 + 4)) {
                        answer[0] = i + 2;
                        answer[1] = j + 2;
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public int[] solution2(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 2; i <= total; i++) {
            if (total%i == 0) { // 약수 중에서
                if (i >= total / i && (i - 2) * (total / i - 2) == yellow) {
                    // 가로>=세로 && (가로-2)*(세로-2)==노란타일수
                    answer[0] = i;
                    answer[1] = total / i;
                    break; // 그대로 끝내야 함
                }
            }
        }

        return answer;
    }
}
