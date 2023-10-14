import java.util.Arrays;

/**
 * 42747. H-Index
 * 이 과학자의 H-Index를 return
 */
public class HIndex42747 {
    public static void main(String[] args) {
        HIndex42747 q = new HIndex42747();
        int[] citations = {3,0,6,1,5};

        System.out.println(q.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;

        // 1. 오름차순 정렬하기
        Arrays.sort(citations);

        // 2. 뒤에서부터 훑으면서 h이상인지 확인하기
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
