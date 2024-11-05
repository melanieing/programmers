// 12926. 시저 암호
public class CaesarCipher_12926 {
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;

        CaesarCipher_12926 q = new CaesarCipher_12926();
        System.out.println(q.solution(s, n));
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        // 입력 문자열의 모든 문자에 대해 반복
        for (char c : s.toCharArray()) {
            sb.append(push(c, n));
        }

        return sb.toString();
    }

    // c를 n만큼 밀어서 반환
    private char push(char c, int n) {
        // A. 알파벳이 아닌 경우 문자를 그대로 이어붙이기
        if (!Character.isAlphabetic(c)) return c;
//        if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) return c;

        // B. 알파벳인 경우 n만큼 밀어 이어 붙이기
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);

        return (char)(offset + position);
    }
}
