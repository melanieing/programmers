import java.util.Arrays;

/**
 * 181856. 배열 비교하기
 * 위에서 정의한 배열의 대소관계에 대하여 arr2가 크다면 -1, arr1이 크다면 1, 두 배열이 같다면 0을 return
 */
public class CompareArrays181856 {
    public static void main(String[] args) {
        CompareArrays181856 q = new CompareArrays181856();
        int[] arr1 = {49, 13};
        int[] arr2 = {70, 11, 2};

        System.out.println(q.solution(arr1, arr2));
    }

    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            if (arr1.length > arr2.length) return 1;
            else return -1;
        } else {
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            return Integer.compare(sum1, sum2);
        }
    }
}
