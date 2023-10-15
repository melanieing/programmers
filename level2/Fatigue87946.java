/**
 * 87946. 피로도
 * 유저가 탐험할 수 있는 최대 던전 수를 return
 */
public class Fatigue87946 {

    static int n;
    static Dungeon[] output;
    static boolean[] visited;
    static int answer = 0;
    static int K = 0;
    public static void main(String[] args) {
        Fatigue87946 q = new Fatigue87946();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(q.solution(k, dungeons));
    }

    public int solution(int k, int[][] dungeons) {

        K = k;
        n = dungeons.length;
        output = new Dungeon[dungeons.length];
        visited = new boolean[dungeons.length];

        // 던전 객체 배열 만들어서 넣기
        Dungeon[] arr = new Dungeon[dungeons.length];
        int idx = 0;
        for (int[] dungeon : dungeons) {
            arr[idx++] = new Dungeon(dungeon[0], dungeon[1]);
        }

        // 가능한 경우의 수 조합해서 찾기
        for (int i = 1; i <= arr.length; i++) {
            combi(arr, 0, arr.length, i, k);
        }

        return answer;
    }

    public static class Dungeon {
        int need; // 최소필요
        int lose; // 소모

        public Dungeon(int need, int lose) {
            this.need = need;
            this.lose = lose;
        }

        public int getNeed() {
            return need;
        }

        public int getLose() {
            return lose;
        }

    }

    public void combi(Dungeon[] arr, int depth, int length, int r, int k) {
        if (depth == r) {
            int tmpAnswer = 0;
            for (Dungeon dungeon : output) {
                if (dungeon == null) continue;
                if (K >= dungeon.getNeed()) { // 최소 필요 소모도 이상
                    K -= dungeon.getLose(); // 소모 피로도를 깎아
                    tmpAnswer++;
                }
            }
            answer = Math.max(tmpAnswer, answer);
            K = k; // 다시 k 초기화
            return;
        }
        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = arr[i];
            combi(arr, depth+1, length, r, k);
            visited[i] = false;
        }
    }

}
