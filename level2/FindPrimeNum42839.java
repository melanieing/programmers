import java.util.HashSet;

/**
 * 42839. 소수 찾기
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return
 */
public class FindPrimeNum42839 {

    static HashSet<Integer> set = new HashSet<>(); // 중복 없도록 하기 위해 Set 사용

    public static void main(String[] args) {
        FindPrimeNum42839 q = new FindPrimeNum42839();
        String numbers = "17";

        System.out.println(q.solution(numbers));
    }

    public int solution(String numbers) {
        // 1. 조합 생성하기
        combinate("", numbers);

        int cnt = 0;
        for (int number : set) {
            if (isPirme(number)) cnt++;
        }

        return cnt;
    }

    public void combinate(String combi, String numbers) {
        if (!combi.isEmpty()) {
            set.add(Integer.parseInt(combi));
        }

        for (int i = 0; i < numbers.length(); i++) {
            combinate(combi + numbers.charAt(i),
                    numbers.substring(0, i) + numbers.substring(i+1));
        }
    }

    public boolean isPirme(int num) { // 소수이면 true, 아니면 false 반환
        if (num <= 1) {
            return false;
        }
        int limit = (int)Math.sqrt(num);

        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
