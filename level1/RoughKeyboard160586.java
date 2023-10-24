import java.util.Arrays;

/**
 * 160586. 대충 만든 자판
 * 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return
 */
public class RoughKeyboard160586 {
    public static void main(String[] args) {
        RoughKeyboard160586 q = new RoughKeyboard160586();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        System.out.println(Arrays.toString(q.solution(keymap, targets)));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        int num = 0;
        for (String target :targets) {
            int cnt = 0;
            for (char c : target.toCharArray()) {
                String str = Character.toString(c);
                int idx = -1;
                for (String key : keymap) {
                    int tmp = key.indexOf(str);
                    if (tmp != -1) { // -1이 아닐 때만 업데이트
                        idx = idx == -1 ? tmp + 1 : Math.min(idx, tmp + 1);
                    }
                }
                if (idx == -1) { // 찾을 수 없는 알파벳이 하나라도 있다면 바로 탈출해도 됨
                    cnt = -1;
                    break;
                } else {
                    cnt += idx;
                }
            }
            answer[num++] = cnt;
        }

        return answer;
    }
}
