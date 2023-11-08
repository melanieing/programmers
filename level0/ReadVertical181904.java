/**
 * 181904. 세로 읽기
 * my_string을 한 줄에 m 글자씩 가로로 적었을 때
 * 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return
 */
public class ReadVertical181904 {
    public static void main(String[] args) {
        ReadVertical181904 q = new ReadVertical181904();
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;

        System.out.println(q.solution(my_string, m, c));
    }

    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int pointer = 0;

        while (pointer < my_string.length()) {
            if (pointer % m == 0) {
                sb.append(my_string.charAt(pointer + c - 1));
            }
            pointer++;
        }

        return sb.toString();
    }
}
