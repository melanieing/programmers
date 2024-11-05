// 12930. 이상한 문자 만들기

public class MakeStrangeChar_12930 {
    public static void main(String[] args) {
        String s = "try hello world";

        MakeStrangeChar_12930 q = new MakeStrangeChar_12930();
        System.out.println(q.solution(s));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true; // 알파벳이 대문자로 변환되어야 하면 true, 소문자로 변환되어야 하면 false

        for (char c : s.toCharArray()) {
            // A. 문자가 공백 문자일 경우
            if (Character.isSpaceChar(c)) {
                // i. 그대로 이어 붙이기
                sb.append(c);
                // ii. 다음 등장하는 알파벳은 대문자
                toUpper = true;
            // B. 공백문자가 아닌 경우
            } else {
                // i. 대소문자 변환하여 이어 붙이기
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                // ii. 다음 등장하는 알파벳의 대소문자는 현재 변환하는 문자와 반대
                toUpper = !toUpper;
            }
        }

        // 2. 구성한 문자열 반환
        return sb.toString();
    }
}
