import java.util.ArrayList;

/**
 * 84512. 모음사전
 * 이 단어가 사전에서 몇 번째 단어인지 return
 */
public class VowelDictionary84512 {

    static ArrayList<StringBuilder> resultList = new ArrayList<>();
    static String[] dictionary = {"A", "E", "I", "O", "U"};
    public static void main(String[] args) {
        VowelDictionary84512 q = new VowelDictionary84512();
        String word = "AAAAE";

        System.out.println(q.solution(word));
    }

    public int solution(String word) {

        StringBuilder sb = new StringBuilder();
        dfs(sb);
        int idx = 1;
        for (StringBuilder s : resultList) {
            if (word.contentEquals(s)) return idx;
            idx++;
        }
        return idx;
    }

    public void dfs(StringBuilder path) {
        if (path.length() > 5) return;

        if (!path.isEmpty()) {
            resultList.add(path);
        }

        for (String dic : dictionary) {
            StringBuilder sb2 = new StringBuilder(path);
            sb2.append(dic);
            dfs(sb2);
        }
    }

}
