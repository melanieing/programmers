import java.util.Arrays;

/**
 * 181927. 마지막 두 원소
 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return
 */
public class LastTwoElements181927 {
    public static void main(String[] args) {
        LastTwoElements181927 q = new LastTwoElements181927();
        int[] num_list = {2,1,6};

        System.out.println(Arrays.toString(q.solution(num_list)));
    }

    public int[] solution(int[] numList) {
        int[] answer = new int[numList.length + 1];
        System.arraycopy(numList, 0, answer, 0, numList.length);

        int lastEl = numList[numList.length - 1];
        int frontEl = numList[numList.length - 2];

        if (lastEl > frontEl) {
            answer[answer.length-1] = lastEl - frontEl;
        } else {
            answer[answer.length -1] = lastEl * 2;
        }

        return answer;
    }
}
