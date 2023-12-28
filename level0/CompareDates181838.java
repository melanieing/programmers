import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 181838. 날짜 비교하기
 * date1이 date2보다 앞서는 날짜라면 1을, 아니면 0을 return
 */
public class CompareDates181838 {
    public static void main(String[] args) throws ParseException {
        CompareDates181838 q = new CompareDates181838();
        int[] date1 = {2021, 12, 28};
        int[] date2 = {2021, 12, 29};

        System.out.println(q.solution(date1, date2));

    }

    public int solution(int[] date1, int[] date2) throws ParseException {
        StringBuilder d1 = new StringBuilder();
        StringBuilder d2 = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            d1.append(date1[i]);
            d2.append(date2[i]);
            if (i != 2) { // 중간 구분자만 넣기
                d1.append("/");
                d2.append("/");
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date ad = formatter.parse(d1.toString());
        Date bd = formatter.parse(d2.toString());

        if (bd.compareTo(ad) == 1) return 1;
        else return 0;

    }
}
