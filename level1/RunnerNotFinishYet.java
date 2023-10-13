import java.util.*;

/**
 * 42576. 완주하지 못한 선수
 * 완주하지 못한 선수의 이름을 return
 */
public class RunnerNotFinishYet {
    public static void main(String[] args) {
        RunnerNotFinishYet q = new RunnerNotFinishYet();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(q.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {

        // 1. (선수이름, 명수)로 맵에 저장 (동명이인이 있으므로 1 이상일 수 있음)
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 2. 완주한 선수들만 맵의 value를 1 줄이기
        for (String c : completion) {
            map.replace(c, map.get(c) - 1);
        }

        // 3. 완주하지 못한 선수만 value가 0이 아닐 것이므로 골라서 출력
        for (String k : map.keySet()) {
            if (!map.get(k).equals(0)) {
                return k;
            }
        }

        return "";
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) { // (선수이름, 1)
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) { // 완주한 선수의 경우 value에서 1 빼기 (동명이인이 있다면 0보다 클 것임)
            map.put(player, map.get(player) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) { // value가 0이 아닌 선수만 출력
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
