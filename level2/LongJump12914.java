/**
 * 12914. 멀리 뛰기
 * 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
 * 여기에 1234567를 나눈 나머지를 리턴하는 함수
 */
public class LongJump12914 {
    public static void main(String[] args) {
        LongJump12914 q = new LongJump12914();
        int n = 4;

        System.out.println(q.solution(n));
    }

    public long solution(int n) {

        long[] dp = new long[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }

}
