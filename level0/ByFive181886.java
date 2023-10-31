import java.util.ArrayList;
import java.util.Arrays;

/**
 * 181886. 5명씩
 * 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return
 */
public class ByFive181886 {
    public static void main(String[] args) {
        ByFive181886 q = new ByFive181886();
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};

        System.out.println(Arrays.toString(q.solution(names)));
    }

    public String[] solution(String[] names) {
        ArrayList<String> list = new ArrayList<>();
        int idx = 0;

        for (String name : names) {
            if (idx % 5 == 0) {
                list.add(name);
            }
            idx++;
        }
        return list.toArray(new String[0]);
    }
}
