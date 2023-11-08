import java.util.HashMap;

/**
 * 131127. 할인 행사
 * 원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return
 */
public class DiscountEvent131127 {
    public static void main(String[] args) {
        DiscountEvent131127 q = new DiscountEvent131127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice",
                            "apple", "pork", "banana", "pork", "rice",
                            "pot", "banana", "apple", "banana"};

        System.out.println(q.solution(want, number, discount));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 사야할 목록 저장 (제품, 개수)
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> tmpMap = new HashMap<>(map); // 복제
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                if (tmpMap.containsKey(item)) { // 구했으면 -1
                    tmpMap.put(item, tmpMap.get(item)-1);
                }
            }
            boolean isPossible = true;
            for (String item : tmpMap.keySet()) {
                if (tmpMap.get(item) > 0) { // 하나라도 못구했으면 바로 탈출
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) answer++; // 모두 다 구한 경우에만 +1
        }

        return answer;
    }
}
