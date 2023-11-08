import java.util.HashSet;

/**
 * 131701. 연속 부분 수열 합의 개수
 * 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수
 */
public class CircleSequence131701 {
    public static void main(String[] args) {
        CircleSequence131701 q = new CircleSequence131701();
        int[] elements = {7,9,1,1,4};

        System.out.println(q.solution(elements));
    }

    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            set.addAll(getSums(elements, i));
        }

        return set.size();
    }

    public HashSet<Integer> getSums(int[] elements, int cnt) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + cnt; j++) {
                if (j >= elements.length) { // 원래 수열 길이를 넘어가면
                    sum += elements[j % elements.length];
                } else { // 원래 수열 길이 안에 있다면
                    sum += elements[j];
                }
            }
            set.add(sum);
        }

        return set;
    }
}
