import java.util.Arrays;

/**
 * 181852. 뒤에서 5등 위로
 * num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return
 */
public class LastFive181852 {
    public static void main(String[] args) {
        LastFive181852 q = new LastFive181852();
        int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};

        System.out.println(Arrays.toString(q.solution(num_list)));
    }

    public int[] solution(int[] numList) {
        return Arrays.stream(numList).sorted().skip(5).toArray();
    }
}
