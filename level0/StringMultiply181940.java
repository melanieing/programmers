/**
 * 181940. 문자열 곱하기
 * my_string을 k번 반복한 문자열을 return
 */
public class StringMultiply181940 {
    public static void main(String[] args) {
        StringMultiply181940 q = new StringMultiply181940();
        String my_string = "string";
        int k  = 3;

        System.out.println(q.solution(my_string, k));
    }

    public String solution(String my_string, int k) {

        return String.valueOf(my_string).repeat(Math.max(0, k));
    }
}
