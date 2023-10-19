import java.util.Arrays;

/**
 * 181869. 공백으로 구분하기 1
 * my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return
 */
public class BlankSeparation181869 {
    public static void main(String[] args) {
        BlankSeparation181869 q = new BlankSeparation181869();
        String my_string = "i love you";

        System.out.println(Arrays.toString(q.solution(my_string)));
    }

    public String[] solution(String myString) {
        return myString.split(" ");
    }
}
