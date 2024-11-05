import java.util.Arrays;
// 12932. 자연수 뒤집어 배열로 만들기
public class ReverseString_12932 {
    public static void main(String[] args) {
        long n = 12345;

        ReverseString_12932 q = new ReverseString_12932();
        System.out.println(Arrays.toString(q.solution(n)));
    }

    public int[] solution(long n) {
        int[] answer = {};

        // 1. 입력받은 숫자를 문자열로 변환
        String str = Long.toString(n);

        // 2. 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();

        // 3. 뒤집힌 문자열을 문자의 배열로 변환
        char[] arr = reversed.toCharArray();

        // 4. 배열의 각 문자를 정수로 변환
        int[] result = new int[arr.length];
        int idx = 0;
        for (char c : arr) result[idx++] = c - '0';

        return result;
    }
}
