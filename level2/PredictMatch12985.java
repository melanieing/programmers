/**
 * 12985. 예상 대진표
 * 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return
 */
public class PredictMatch12985 {
    public static void main(String[] args) {
        PredictMatch12985 q = new PredictMatch12985();
        int n = 8; 
        int a = 4;
        int b = 7;

        System.out.println(q.solution(n, a, b));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        do {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        } while (a != b);

        return answer;
    }
}
