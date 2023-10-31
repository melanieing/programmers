import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 181885. 할 일 목록
 * todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return
 */
public class TodoList181885 {
    public static void main(String[] args) {
        TodoList181885 q = new TodoList181885();
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        System.out.println(Arrays.toString(q.solution(todo_list, finished)));
    }

    public String[] solution(String[] todo_list, boolean[] finished) {
        // 아직 못 끝낸 할 일 갯수 구하기
        Stream<Boolean> notFinishedStream = IntStream.range(0, finished.length).mapToObj(idx -> finished[idx]);
        long notFinishedCnt = notFinishedStream.filter(b -> b.equals(Boolean.FALSE)).count();

        // 반환할 배열 생성
        String[] answer = new String[(int)notFinishedCnt];

        int idx = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) answer[idx++] = todo_list[i]; // 못 끝낸 할 일만 넣기
        }

        return answer;
    }

}
