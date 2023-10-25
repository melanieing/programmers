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

        int minX = 0;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MAX_VALUE;
        int maxY = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            String tmp = wallpaper[i];
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (tmp.charAt(j) == '#') {
                    minX = Math.max(j, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.min(i, maxX);
                    maxY = Math.max(i, maxY);
                    System.out.println("i : " + i + " j : " + j);
                }
            }
        }

        answer[0] = maxX;
        answer[1] = minY;
        answer[2] = maxY + 1;
        answer[3] = minX + 1;

        return answer;
    }
}
