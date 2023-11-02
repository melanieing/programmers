import java.util.ArrayList;
import java.util.Arrays;

/**
 * 181867. x 사이의 개수
 * myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return
 */
public class BetweenX181867 {
    public static void main(String[] args) {
        BetweenX181867 q = new BetweenX181867();
        String myString = "oxooxoxxox";

        System.out.println(Arrays.toString(q.solution(myString)));
    }

    public int[] solution(String myString) {

        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c == 'x') { // x를 만나면 그 전까지의 길이를 리스트에 추가하고 초기화
                list.add(sb.length());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        list.add(sb.length()); // 마지막 원소 추가

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
