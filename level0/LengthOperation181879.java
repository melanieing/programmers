import java.util.Arrays;

/**
 * 181879. 길이에 따른 연산
 * 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return
 */
public class LengthOperation181879 {
    public static void main(String[] args) {
        LengthOperation181879 q = new LengthOperation181879();
        int[] num_list = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};

        System.out.println(q.solution(num_list));
    }

    public int solution(int[] numList) {
        int answer = 0;

        if (numList.length >= 11) {
            answer = Arrays.stream(numList).sum();
        } else {
            answer = Arrays.stream(numList).reduce(1, (a, b) -> a * b);
        }

        return answer;
    }

}
