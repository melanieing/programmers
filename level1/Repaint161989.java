import java.util.Arrays;

/**
 * 161989. 덧칠하기
 * 롤러로 페인트칠해야 하는 최소 횟수를 return
 */
public class Repaint161989 {
    public static void main(String[] args) {
        Repaint161989 q = new Repaint161989();
        int n = 8;                  // 총 구역의 갯수
        int m = 4;                  // 롤러의 길이
        int[] section = {2,3,6};    // 칠해야 하는 구역의 갯수

        System.out.println(q.solution(n, m, section));
    }

    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + (m - 1);
        int answer = 1;

        for (int i : section) {
            if (i < start || i > end) { // 범위를 벗어나면
                start = i;
                end = i + (m - 1);
                answer++;
            }
        }

        return answer;
    }
    public int solution2(int n, int m, int[] section) { // 시간 초과
        int answer = Integer.MAX_VALUE;
        int[] arr = new int[n+1];
        for (int s : section) {
            arr[s]++;
        }

        for (int i = 1; i <= n - m + 1; i++) { // 시작지점 (1~5)
            int[] copy = arr.clone();
            int cnt = 0;
            int tmp = i;
            while (true) {
                if (i + m - 1 <= n) {
                    if (!paint(i, m, copy)) { // 색을 다 못 칠했으면 계속 반복
                        cnt++;
                        i++;
                    } else { // 색을 다 칠했으면 끝내기
                        cnt++;
                        i = tmp; // i 다시 원상복구
                        answer = Math.min(answer, cnt);
                        break;
                    }
                } else {
                    i = tmp;
                    break;
                }
            }
        }

        return answer;

    }

    public boolean paint(int start, int m, int[] arr) { // 다 칠했으면 true 하나라도 못칠했으면 false
        for (int i = start; i < start + m; i++) {
            arr[i]--;
        }
        return Arrays.stream(arr).noneMatch(v -> v >= 1);
    }

}
