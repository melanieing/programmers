/**
 * 12945. 피보나치 수
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴
 */
public class Fibonacci12945 {
    static int[] arr;

    public static void main(String[] args) {
        Fibonacci12945 q = new Fibonacci12945();
        int n = 10000;

        System.out.println(q.solution(n));
    }
    public int solution(int n) {
        arr = new int[100001];
        arr[0] = 0;
        arr[1] = 1;

        return fiboMemo(n) % 1234567;
    }

    public int fiboMemo(int n) {

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }

        return arr[n];
    }

}
