import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

/**
 * 42578. 의상
 * 서로 다른 옷의 조합의 수를 return
 * 하루에 최소 한 개의 의상은 입음
 * 각 종류별로 최대 1가지 의상만 착용 가능
 */
public class Clothes42578 {
    public static void main(String[] args) {
        Clothes42578 q = new Clothes42578();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(q.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1; // 곱해야 하므로 1로 초기화

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] value : clothes) {
            map.put(value[1], map.getOrDefault(value[1], 0) + 1); // 각 의상 종류별로 갯수 더하여 기록
        }

        for (String key : map.keySet()) { // 모든 경우의 수 = 의상별 갯수 + 1을 곱한 것
            answer *= map.get(key) + 1;
        }

        return answer - 1; // 아무것도 안 입을 수는 없으므로 1을 빼주기
    }

    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (answer, count) -> answer * (count + 1))
                .intValue() - 1;
    }
}
