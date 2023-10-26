import java.util.*;

/**
 * 178871. 달리기 경주
 * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return
 */
public class Running178871 {
    public static void main(String[] args) {
        Running178871 q = new Running178871();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(q.solution(players, callings)));
    }

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i); // (kai, 3)
            rankMap.put(i, players[i]); // (3, kai)
        }

        for (String winningPlayer : callings) {
            int curRank = playerMap.get(winningPlayer); // 3
            String frontplayer = rankMap.get(curRank - 1); // poe

            playerMap.put(winningPlayer, curRank - 1); // (kai, 2)
            playerMap.put(frontplayer, curRank); // (poe, 3)
            rankMap.put(curRank - 1, winningPlayer); // (2, kai)
            rankMap.put(curRank, frontplayer); // (3, poe)
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            answer[i] = rankMap.get(i);
        }

        return answer;

    }
}
