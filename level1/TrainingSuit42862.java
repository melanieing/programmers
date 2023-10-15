import java.util.Arrays;

/**
 * 42862. 체육복
 * 체육수업을 들을 수 있는 학생의 최댓값을 return
 */
public class TrainingSuit42862 {
    public static void main(String[] args) {
        TrainingSuit42862 q = new TrainingSuit42862();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,3,5};

        System.out.println(q.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        for (int l : lost) {
            arr[l]--;
        }
        for (int r : reserve) {
            arr[r]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length-1) {
                if (arr[i] == 0 && arr[i-1] > 1) {
                    arr[i-1]--;
                    arr[i]++;
                }
            } else if (arr[i] == 0) {
                if (arr[i-1] > 1) {
                    arr[i-1]--;
                    arr[i]++;
                } else if (arr[i+1] > 1) {
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= 1) {
                cnt++;
            }
        }

        return cnt;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] array = new int[n+1]; // 학생번호를 그대로 인덱스로 사용하기 위해서 +1
        Arrays.fill(array, 1); // 모두 체육복을 1개씩 가지고 있다고 가정

        for (int i : lost) {
            array[i]--; // 도난당한 사람들은 체육복 -1
        }

        for (int i : reserve) {
            array[i]++; // 여유분이 있는 사람들은 체육복 +1
        }

        for (int i = 1; i < array.length; i++) {
            if (i==1 && array[i] == 0) { // 맨 앞사람이라면 뒷사람에게서 받을 수밖에 없음
                if (array[i+1] >= 2) {
                    array[i+1]--;
                    array[i]++;
                }
            } else if (i==array.length-1 && array[i] == 0) { // 맨 뒷사람이라면 앞사람에게서 받을 수밖에 없음
                if (array[i-1] >= 2) {
                    array[i-1]--;
                    array[i]++;
                }
            } else { // 중간 사람이라면
                if (array[i] == 0 && array[i-1] >= 2) { // 앞에서 받거나
                    array[i-1]--;
                    array[i]++;
                } else if (array[i] == 0 && array[i+1] >= 2) { // 뒤에서 받거나
                    array[i+1]--;
                    array[i]++;
                }
            }
        }

        for (int i = 1; i< array.length; i++) {
            if (array[i] >= 1) answer++; // 체육복을 가진 사람만큼 더해주기
        }

        return answer;
    }
}
