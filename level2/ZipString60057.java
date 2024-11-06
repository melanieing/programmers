import java.util.ArrayList;
import java.util.List;
// 60057. 문자열 압축
public class ZipString60057 {
    public static void main(String[] args) {
        String s = "aabbaccc";

        ZipString60057 q = new ZipString60057();
        System.out.println(q.solution(s));

    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        // 1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축
            int compressed = compress(s, length);
            // 4. 1~3 과정으로 압축된 문자열 중 가장 짧은 길이 반환
            if (compressed < min) {
                min = compressed;
            }
        }

        return min;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = ""; // 직전에 등장한 문자열
        int cnt = 0; // 등장 횟수

        // 2. 설정된 길이만큼 문자열을 잘라낸 token의 배열 생성
        for (String token : split(source, length)) {
            // 3. 문자열을 비교하며 token의 배열을 하나의 문자열로 압축
            if (token.equals(last)) { // 현재 검사하는 문자열 token이 직전 등장한 문자열과 같다면 등장 횟수만 증가
                cnt++;
            } else { // 새로운 토큰 등장
                if (cnt > 1) sb.append(cnt); // 등장 횟수는 2 이상일 때만 압축문자열에 포함
                sb.append(last);
                // 현재 검사한 token부터 다시 셀 수 있도록 last, cnt 업데이트
                last = token;
                cnt = 1;
            }
        }

        if (cnt > 1) sb.append(cnt);
        sb.append(last);

        return sb.length();
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        // source를 length만큼 잘라서 tokens 리스트에 추가
        for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
            int endIdx = startIdx + length;
            if (endIdx > source.length()) endIdx = source.length();
            tokens.add(source.substring(startIdx, endIdx));
        }

        return tokens;
    }
}
