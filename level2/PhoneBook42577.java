import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 42577. 전화번호 목록
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
 */
public class PhoneBook42577 {
    public static void main(String[] args) {
        PhoneBook42577 q = new PhoneBook42577();
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(q.solution(phone_book)); //false
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>();

        Collections.addAll(set, phone_book);

        for (String phoneNum : phone_book) {
            for (int i = 1; i < phoneNum.length(); i++) {
                if (set.contains(phoneNum.substring(0, i))) { // 접두어만 찾기
                    return false;
                }
            }
        }

        return answer;
    }
    public boolean solution2(String[] phoneBook){ // 시간초과
        boolean answer = true;

        Arrays.sort(phoneBook);
        HashSet<String> set;
        for (String p : phoneBook) {
            set = Arrays.stream(phoneBook)
                    .filter(s -> !s.equals(p) && s.length() >= p.length())
                    .map(s -> s.substring(0, p.length()))
                    .collect(Collectors.toCollection(HashSet::new));
            if (set.contains(p)) return false;
        }

        return answer;
    }
}
