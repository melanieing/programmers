import java.util.Arrays;

/**
 * 42746. 가장 큰 수
 * 정수를 이어 붙여, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
 */
public class MaxNum42746 {
    public static void main(String[] args) {
        MaxNum42746 q = new MaxNum42746();
        int[] numbers = {6,10,2};

        System.out.println(q.solution(numbers));
    }

    public String solution(int[] numbers) {
        // 1. String으로 변환해서 배열에 저장
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 문자열 이어붙인 값을 내림차순으로 정렬
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 3. 최종 정렬된 배열의 첫번째 요소가 0일 경우는 "0"을 반환하도록 별도 지정
        if (arr[0].equals("0")) return "0";

        // 4. 문자열 합치기
        StringBuilder answer = new StringBuilder();
        for (String s : arr) {
            answer.append(s);
        }

        return answer.toString();
    }

}
