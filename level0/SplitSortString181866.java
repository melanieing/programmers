import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 181866. 문자열 잘라서 정렬하기
 * "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 사전순으로 정렬한 배열을 return
 */
public class SplitSortString181866 {
    public static void main(String[] args) {
        SplitSortString181866 q = new SplitSortString181866();
        String myString = "axxbxx";

        System.out.println(Arrays.toString(q.solution(myString)));
    }

    public String[] solution(String myString) {
        // x 기준으로 문자열 분리
        String[] arr = myString.split("x");

        // array -> arrayList로 변환해서 빈 문자열 제거
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        list.removeIf(String::isBlank);

        // 사전순으로 정렬
        Collections.sort(list);

        return list.toArray(new String[0]);
    }
}
