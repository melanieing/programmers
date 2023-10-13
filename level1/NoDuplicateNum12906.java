import java.util.ArrayList;
import java.util.Arrays;

/**
 * 12906. 같은 숫자는 싫어
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 순서를 유지하며 return
 */
public class NoDuplicateNum12906 {
    public static void main(String[] args) {
        NoDuplicateNum12906 q = new NoDuplicateNum12906();
        int[] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(q.solution(arr)));
    }

    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]); // 1번째 원소는 먼저 넣어두기

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i-1] != arr[i]) { // 2번째로 넣는 원소부터 연속적인지 체크하기
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                if (arr[i] != arr[i-1]) {
                    list.add(arr[i]);
                }
            } else {
                list.add(arr[i]);
            }
        }

        int size = 0;
        int[] answer = new int[list.size()];
        for (int i : list) {
            answer[size++] = i;
        }
        return answer;
    }
}
