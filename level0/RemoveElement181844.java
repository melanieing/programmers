import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 181844. 배열의 원소 삭제하기
 * arr의 원소 중 delete_list의 원소를 모두 삭제하고
 * 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return
 */
public class RemoveElement181844 {
    public static void main(String[] args) {
        RemoveElement181844 q = new RemoveElement181844();
        int[] arr = {293, 1000, 395, 678, 94};
        int[] delete_list = {94, 777, 104, 1000, 1, 12};

        System.out.println(Arrays.toString(q.solution(arr, delete_list)));
    }

    public int[] solution(int[] arr, int[] deleteList) {
        // array -> list
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int del : deleteList) {
            list.remove(Integer.valueOf(del)); // 객체로 삭제
        }

        // list -> array
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
