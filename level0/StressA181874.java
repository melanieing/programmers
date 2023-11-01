/**
 * 181874. A 강조하기
 * myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고, "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 return
 */
public class StressA181874 {
    public static void main(String[] args) {
        StressA181874 q = new StressA181874();
        String myString = "abstract algebra";

        System.out.println(q.solution(myString));

    }

    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                sb.append('A');
            } else if (c != 'A' && Character.isUpperCase(c)) {
                sb.append(Character.toString(c).toLowerCase());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
