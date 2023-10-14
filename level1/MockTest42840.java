import java.util.ArrayList;
import java.util.Arrays;

/**
 * 42840. 모의고사
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
 */
public class MockTest42840 {
    public static void main(String[] args) {
        MockTest42840 q = new MockTest42840();
        int[] answers = {1,2,3,4,5};

        System.out.println(Arrays.toString(q.solution(answers)));
    }

    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        // 1. 각 점수 저장할 배열 생성
        int[] maxArr = new int[3];

        // 2. 점수 계산해서 저장
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == first[i % first.length]) {
                maxArr[0]++;
            }
            if (answer == second[i % second.length]) {
                maxArr[1]++;
            }
            if (answer == third[i % third.length]) {
                maxArr[2]++;
            }
        }

        // 3. 최대 점수 구하기
        int max = Arrays.stream(maxArr).max().getAsInt();

        // 4. 최대 점수 받은 사람 구해서 리스트에 넣기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] == max) {
                list.add(i+1);
            }
        }

        // 5. 리스트 -> 배열로 변환 및 오름차순 정렬
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }

    public int[] solution2(int[] answers) {
        int[] score = {0, 0, 0};

        int[] a = {1, 2, 3, 4, 5}; // 5개
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개

        // 각 수포자마다 점수내기
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) score[0]++;
            if (answers[i] == b[i % b.length]) score[1]++;
            if (answers[i] == c[i % c.length]) score[2]++;
        }

        // 최대점수 구하기
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        // 최대점수와 일치하는 수포자 리스트 만들기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) list.add(i+1);
        }

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        int size = 0;
        for (int i : list) {
            answer[size++] = i;
        }

        return answer;
    }
}
