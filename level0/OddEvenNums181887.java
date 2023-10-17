/**
 * 181887. 홀수 vs 짝수
 * 가장 첫 번째 원소를 1번 원소라고 할 때, 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return
 */
public class OddEvenNums181887 {
    public static void main(String[] args) {
        OddEvenNums181887 q = new OddEvenNums181887();
        int[] num_list = {4, 2, 6, 1, 7, 6};

        System.out.println(q.solution(num_list));
    }

    public int solution(int[] numList) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < numList.length; i++) {
            if (i % 2 == 0) { // 0, 2, 4, ... -> 홀수번째(1부터 시작하므로)
                oddSum += numList[i];
            } else { // 1, 3, 5, ... -> 짝수번째
                evenSum += numList[i];
            }
        }

        return Math.max(oddSum, evenSum);
    }
}
