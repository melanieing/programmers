/**
 * 181933. flag에 따라 다른 값 반환하기
 * flag가 true면 a + b를 false면 a - b를 return
 */
public class FlagReturn181933 {
    public static void main(String[] args) {
        FlagReturn181933 q = new FlagReturn181933();
        int a = -4;
        int b = 7;
        boolean flag = true;

        System.out.println(q.solution(a, b, flag));
    }

    public int solution(int a, int b, boolean flag) {
        if (flag) {
            return a + b;
        } else {
            return a- b;
        }
    }
}
