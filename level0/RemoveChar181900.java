import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 181900. 글자 지우기
 * my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 문자열을 return
 */
public class RemoveChar181900 {
    public static void main(String[] args) {
        RemoveChar181900 q = new RemoveChar181900();
        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        System.out.println(q.solution(my_string, indices));
    }

    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
//        List<Integer> list = Arrays.stream(indices).boxed().collect(Collectors.toList());
        List<Integer> list = Arrays.stream(indices).boxed().toList(); // Java 16부터 가능
        for (int i = 0; i < my_string.length(); i++) {
            if (list.contains(i)) continue; // 글자 지우기
            sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }
}
