import java.util.Arrays;

/**
 * 181920. 카운트 업
 * start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return
 */
public class CountUp181920 {
    public static void main(String[] args) {
        CountUp181920 q = new CountUp181920();
        int start_num = 3;
        int end_num = 10;

        System.out.println(Arrays.toString(q.solution(start_num, end_num)));
    }

    public int[] solution(int startNum, int endNum) {
        int[] answer = new int[endNum-startNum+1];

        for (int i = startNum; i <= endNum; i++) {
            answer[i-startNum] = i;
        }

        return answer;
    }
}
