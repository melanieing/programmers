/**
 * 181936. 공배수
 * number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return
 */
public class CommonMultiple181936 {
    public static void main(String[] args) {
        CommonMultiple181936 q = new CommonMultiple181936();
        int number = 60;
        int n = 2;
        int m = 3;

        System.out.println(q.solution(number, n, m));
    }

    public int solution(int number, int n, int m) {
        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
