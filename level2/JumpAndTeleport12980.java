/**
 * 12980. 점프와 순간 이동
 * 사용해야 하는 건전지 사용량의 최솟값을 return
 */
public class JumpAndTeleport12980 {
    public static void main(String[] args) {
        JumpAndTeleport12980 q = new JumpAndTeleport12980();
        int N = 6;

        System.out.println(q.solution(N));
    }

    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {   // 2로 나누어지면 순간이동으로 갈 수 있음
                n /= 2;
            } else {            // 2로 나누어지지 않으면 점프해야 함
                n--;
                answer++;
            }
        }

        return answer;
    }
}
