/**
 * 181906. 접두사인지 확인하기
 * is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return
 */
public class IfPrefix181906 {
    public static void main(String[] args) {
        IfPrefix181906 q = new IfPrefix181906();
        String my_string = "banana";
        String is_prefx = "ban";

        System.out.println(q.solution(my_string, is_prefx));
    }

    public int solution(String myString, String isPrefx) {
        if (myString.startsWith(isPrefx)) return 1;
        else return 0;
    }
}
