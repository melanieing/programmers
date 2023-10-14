import java.util.Arrays;

/**
 * 86491. 최소직사각형
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return
 */
public class MinRectangle86491 {
    public static void main(String[] args) {
        MinRectangle86491 q = new MinRectangle86491();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(q.solution(sizes));
    }

    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            int a = size[0];
            int b = size[1];
            x = Math.max(x, Math.max(a, b));
            y = Math.max(y, Math.min(a, b));
        }

        return x * y;
    }

    public int solution2(int[][] sizes) {

        int[] widthArr = new int[sizes.length];
        int[] heightArr = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                widthArr[i] = sizes[i][1];
                heightArr[i] = sizes[i][0];
            } else {
                widthArr[i] = sizes[i][0];
                heightArr[i] = sizes[i][1];
            }
        }
        Arrays.sort(widthArr);
        Arrays.sort(heightArr);

        return widthArr[sizes.length-1] * heightArr[sizes.length-1];
    }

}
