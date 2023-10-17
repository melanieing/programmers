/**
 * 181907. 문자열의 앞의 n글자
 * my_string의 앞의 n글자로 이루어진 문자열을 return
 */
public class StringFrontIndex181907 {
    public static void main(String[] args) {
        StringFrontIndex181907 q = new StringFrontIndex181907();
        String my_string = "ProgrammerS123";
        int n = 11;

        System.out.println(q.solution(my_string, n));
    }

    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}
