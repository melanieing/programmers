import java.util.ArrayList;
import java.util.List;
// 프로그래머스 120956 옹알이 (1)

public class Babbling120956 {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        // 발음할 수 있는 단어들 목록
        String[] onlyStrs = {"aya", "ye", "woo", "ma"};

        // 1개로 만들 수 있는 단어들 먼저 넣어놓기
        ArrayList<String> onlyWords = new ArrayList<String>(List.of(onlyStrs));

        // 2개로 만들 수 있는 단어들 넣기
        for (int i = 0; i < onlyStrs.length; i++) {
            for (int j = 0; j < onlyStrs.length; j++) {
                if (i == j) {
                    continue;
                } // 중복제거
                onlyWords.add(onlyStrs[i] + onlyStrs[j]);
            }
        }

        // 3개로 만들 수 있는 단어들 넣기
        for (int i = 0; i < onlyStrs.length; i++) {
            for (int j = 0; j < onlyStrs.length; j++) {
                for (int k = 0; k < onlyStrs.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    } // 중복제거
                    onlyWords.add(onlyStrs[i] + onlyStrs[j] + onlyStrs[k]);
                }
            }
        }

        // 4개로 만들 수 있는 단어들 넣기
        for (int i = 0; i < onlyStrs.length; i++) {
            for (int j = 0; j < onlyStrs.length; j++) {
                for (int k = 0; k < onlyStrs.length; k++) {
                    for (int l = 0; l < onlyStrs.length; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        } // 중복제거
                        onlyWords.add(onlyStrs[i] + onlyStrs[j] + onlyStrs[k] + onlyStrs[l]);
                    }
                }
            }
        }

        // 발음할 수 있는 단어라면 카운트
        for (String s : babbling) {
            if (onlyWords.contains(s)) {
                answer++;
            }
        }

        return answer;

    }
}
