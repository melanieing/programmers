/**
 * 181839. 주사위 게임 1
 * 최종으로 얻는 점수를 return
 */
public class DiceGame181839 {
    public static void main(String[] args) {
        DiceGame181839 q = new DiceGame181839();
        int a = 3;
        int b = 5;

        System.out.println(q.solution(a, b));
    }

    public int solution(int a, int b) {
        int score = 0;

        if (a % 2 != 0 && b % 2 != 0) {         // a와 b가 모두 홀수라면
            score += a * a + b * b;
        } else if (a % 2 == 0 && b % 2 == 0) {  // a와 b 모두 홀수가 아니라면
            score += Math.abs(a - b);
        } else {                                // 그 외의 경우
            score += 2 * (a + b);
        }

        return score;
    }
}
