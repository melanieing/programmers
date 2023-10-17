/**
 * 181863. rny_string
 * rny_string의 모든 'm'을 "rn"으로 바꾼 문자열을 return
 */
public class RnyString181863 {
    public static void main(String[] args) {
        RnyString181863 q = new RnyString181863();
        String rny_string = "masterpiece";

        System.out.println(q.solution(rny_string));
    }

    public String solution(String rny_string) {

        rny_string = rny_string.replace("m", "rn");

        return rny_string;
    }
}
