/**
 * 181843. 부분 문자열인지 확인하기
 * target이 문자열 my_string의 부분 문자열이라면 1을, 아니라면 0을 return
 */
public class IfSubString181843 {
    public static void main(String[] args) {
        IfSubString181843 q = new IfSubString181843();
        String my_string = "banana";
        String target = "ana";

        System.out.println(q.solution(my_string, target));
    }

    public int solution(String myString, String target) {
        if (myString.contains(target)) return 1;
        else return 0;
    }
}
