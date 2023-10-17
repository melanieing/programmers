/**
 * 181926. 수 조작하기 1
 * 위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return
 */
public class ManipulateNums181926 {
    public static void main(String[] args) {
        ManipulateNums181926 q = new ManipulateNums181926();
        int n = 0;
        String control = "wsdawsdassw";

        System.out.println(q.solution(n, control));
    }

    public int solution(int n, String control) {
        for (char c : control.toCharArray()) {
            if (c == 'w') {
                n++;
            } else if (c == 's') {
                n--;
            } else if (c == 'd') {
                n += 10;
            } else if (c == 'a') {
                n -= 10;
            }
        }

        return n;
    }
}
