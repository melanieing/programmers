/**
 * 12903. 가운데 글자 가져오기
 * 단어의 길이가 짝수라면 가운데 두글자를 반환
 */
public class FetchMiddle12903 {
    public static void main(String[] args) {
        FetchMiddle12903 q = new FetchMiddle12903();
        String s = "abcde";

        System.out.println(q.solution(s));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();

        if (size % 2 != 0) {
            sb.append(s.charAt(size / 2));
        } else {
            sb.append(s, size / 2 - 1, size / 2 + 1);
        }

        return sb.toString() ;
    }
}
