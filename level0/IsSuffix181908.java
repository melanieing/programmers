/**
 * 181908. 접미사인지 확인하기
 * is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return
 */
public class IsSuffix181908 {
    public static void main(String[] args) {
        IsSuffix181908 q = new IsSuffix181908();
        String my_string = "banana";
        String is_suffix = "banana";

        System.out.println(q.solution(my_string, is_suffix));
    }

    public int solution(String myString, String isSuffix) {
        if (!myString.contains(isSuffix) || isSuffix.length() > myString.length()) return 0;

        boolean flag = true;
        int idx = 0;
        for (int i = myString.length() - isSuffix.length(); i < myString.length(); i++) {
            if (myString.charAt(i) != isSuffix.charAt(idx++)) {
                flag = false;
                break;
            }
        }

        if (flag) return 1;
        else return 0;
    }
}
