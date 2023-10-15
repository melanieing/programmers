import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 181951. a와 b 출력하기
 * 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드
 */
public class PrintAB181951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println("a = " + a);
        System.out.println("b = " + b);    }


}
