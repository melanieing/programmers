import java.util.Arrays;

/**
 * 161990. 바탕화면 정리
 * 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return
 */
public class Wallpaper161990 {
    public static void main(String[] args) {
        Wallpaper161990 q = new Wallpaper161990();
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        System.out.println(Arrays.toString(q.solution(wallpaper)));
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int rdy = Integer.MIN_VALUE;
        int luy = Integer.MAX_VALUE;
        int lux = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    rdy = Math.max(j, rdy);
                    luy = Math.min(j, luy);
                    lux = Math.min(i, lux);
                    rdx = Math.max(i, rdx);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;

        return answer;
    }
}
