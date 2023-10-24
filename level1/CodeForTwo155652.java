/**
 * 155652. 둘만의 암호
 * s를 변환한 결과를 return
 */
public class CodeForTwo155652 {
    public static void main(String[] args) {
        CodeForTwo155652 q = new CodeForTwo155652();
        String s = "bcdefghijklmnopqrstuvwxyz";
        String skip = "a";
        int index = 1;

        System.out.println(q.solution(s, skip, index));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int cnt = 0;
            int next = c+1 > 'z' ? 'a' : c+1; // z 넘어가면 a로 돌아가기
            while (cnt != index) {
                if (skip.contains(Character.toString((char)next))) { // skip에 포함될 때
                    next++;
                } else { // skip에 포함되지 않을 때
                    cnt++;
                    if (cnt == index) { // index 채웠으면 끝내기
                        break;
                    } else {            // index 못 채웠으면 더 돌기
                        next++;
                    }
                }
                if (next >= 'z') { // z 넘어가면 a로 돌아가기
                    next = 'a';
                }
            }
            sb.append((char)next);
        }

        return sb.toString();
    }
}
