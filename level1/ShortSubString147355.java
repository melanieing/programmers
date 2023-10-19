/**
 * 147355. 크기가 작은 부분 문자열
 * 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return
 */
public class ShortSubString147355 {
    public static void main(String[] args) {
        ShortSubString147355 q = new ShortSubString147355();
        String t = "3141592";
        String p = "271";

        System.out.println(q.solution(t, p));
    }

    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String str = t.substring(i, i + p.length());
            if (Long.parseLong(str) <= Long.parseLong(p)) answer++; // Integer의 범위를 벗어남
        }

        return answer;
    }
}
