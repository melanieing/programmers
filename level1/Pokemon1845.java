import java.util.HashSet;

/**
 * 1845. 폰켓몬
 * 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return
 */
public class Pokemon1845 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        // 1. 가질 수 있는 폰켓몬 수 구하기
        int answer = nums.length / 2;

        // 2. 중복을 제거한 폰켓몬 종류의 수 구하기
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        // 최종 폰켓몬 종류의 수
        int cnt = set.size();

        // 3. 가질 수 있는 폰켓몬 종류의 수의 최댓값 구하기
        return Math.min(cnt, answer);

    }
}
