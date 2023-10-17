import java.util.ArrayList;
import java.util.Arrays;

/**
 * 181888. n개 간격의 원소들
 * num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를 return
 */
public class IntervalElements181888 {
    public static void main(String[] args) {
        IntervalElements181888 q = new IntervalElements181888();
        int[] num_list = {4, 2, 6, 1, 7, 6};
        int n = 2;

        System.out.println(Arrays.toString(q.solution(num_list, n)));
        
    }

    public int[] solution(int[] numList, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numList.length; i += n) {
            list.add(numList[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
