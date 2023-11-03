/**
 * 181865. 간단한 식 계산하기
 * 주어진 식을 계산한 정수를 return
 */
public class Binomial181865 {
    public static void main(String[] args) {
        Binomial181865 q = new Binomial181865();
        String binomial = "43 + 12";

        System.out.println(q.solution(binomial));
    }

    public int solution(String binomial) {
        int answer = 0;
        binomial = binomial.replace(" ", "");

        String[] numbers = binomial.split("\\D+"); // 숫자만 추출
        String operator = binomial.replaceAll("\\d+", ""); // 연산자만 추출

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);

        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> answer;
        };

    }
}
