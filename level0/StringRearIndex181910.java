/**
 * 181910. 문자열의 뒤의 n글자
 * my_string의 뒤의 n글자로 이루어진 문자열을 return
 */
public class StringRearIndex181910 {
    public static void main(String[] args) {
        StringRearIndex181910 q = new StringRearIndex181910();
        String my_string = "ProgrammerS123";
        int n = 11;

        System.out.println(q.solution(my_string, n));
    }

    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }
}
