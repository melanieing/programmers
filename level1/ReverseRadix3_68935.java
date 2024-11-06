// 68935. 3진법 뒤집기
public class ReverseRadix3_68935 {
    public static void main(String[] args) {
        int n = 45;

        ReverseRadix3_68935 q = new ReverseRadix3_68935();
        System.out.println(q.solution(n));

    }

    public int solution(int n) {
        // 1. 정수를 3진법으로 변환
        String str = Integer.toString(n, 3);

        // 2. 변환된 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();

        // 3. 뒤집은 문자열을 정수로 변환
        return Integer.valueOf(reversed, 3);
    }
}
