/**
 * 181836. 그림 확대
 * 그림 파일을 가로 세로로 k배 늘린 그림 파일을 나타내도록 문자열 배열을 return
 */
public class PictureZoomIn181836 {
    public static void main(String[] args) {
        PictureZoomIn181836 q = new PictureZoomIn181836();
        String[] picture = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        int k = 2;

        for (String s : q.solution(picture, k)) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];

        int index = 0;
        for (String line : picture) {
            StringBuilder sb = new StringBuilder();

            for (char c : line.toCharArray()) {
                // 각 문자를 k번씩 반복
                sb.append(String.valueOf(c).repeat(Math.max(0, k)));
            }

            for (int i = 0; i < k; i++) {
                answer[index++] = sb.toString();
            }
        }

        return answer;
    }
}
