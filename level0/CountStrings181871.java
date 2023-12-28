/**
 * 181871. 문자열이 몇 번 등장하는지 세기
 * myString에서 pat이 등장하는 횟수를 return
 */
public class CountStrings181871 {
    public static void main(String[] args) {
        CountStrings181871 q = new CountStrings181871();
        String myString = "banana";
        String pat = "ana";
        System.out.println(q.solution(myString, pat));
    }

    public int solution(String myString, String pat) {
        int answer = 0;

        int index = myString.indexOf(pat);

        while (index != -1) {
            answer++;
            index = myString.indexOf(pat, index + 1); // 방금 찾은 인덱스 다음부터 찾기
        }

        return answer;
    }
}
