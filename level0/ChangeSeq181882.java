import java.util.Arrays;

/**
 * 181882. 조건에 맞게 수열 변환하기 1
 * 수열 변환해서 return
 */
public class ChangeSeq181882 {
    public static void main(String[] args) {
        ChangeSeq181882 q = new ChangeSeq181882();
        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println(Arrays.toString(q.solution(arr)));
    }

    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            } else if (arr[i] < 50 && arr[i] % 2 != 0){
                arr[i] *= 2;
            }
        }
        return arr;
    }
}
