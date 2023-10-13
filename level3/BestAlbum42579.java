import java.util.*;

/**
 * 42579. 베스트앨범
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
 */
public class BestAlbum42579 {

    static class Song implements Comparable<Song> {
        Integer num;        // 고유 번호
        String genre;       // 장르
        Integer playCnt;    // 재생 횟수

        public Song(Integer num, String genre, Integer playCnt) {
            this.num = num;
            this.genre = genre;
            this.playCnt = playCnt;
        }

        public Integer getNum() {
            return num;
        }

        public String getGenre() {
            return genre;
        }

        public Integer getPlayCnt() {
            return playCnt;
        }

        @Override
        public int compareTo(Song o) {
            if (!Objects.equals(o.getPlayCnt(), this.getPlayCnt())) {
                return o.getPlayCnt() - this.getPlayCnt(); // 재생 횟수로 비교 (내림차순)
            } else {
                return this.getNum() - o.getNum(); // 고유 번호로 비교 (오름차순)
            }
        }

    }
    public static void main(String[] args) {
        BestAlbum42579 q = new BestAlbum42579();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(q.solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = genres.length;

        // 1. 노래 객체 리스트 저장
        Song[] songs = new Song[length];
        for (int i = 0; i < plays.length; i++) {
            songs[i] = new Song(i, genres[i], plays[i]); // (고유번호, 장르, 재생 횟수)
        }

        // 2. 노래 객체 리스트를 재생 횟수 내림차순으로 정렬
        Arrays.sort(songs);

        // 3. 장르 배열 맵에 (장르, 총 재생 횟수)로 넣기
        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 4. 장르 배열 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genreMap.entrySet());
        entryList.sort(((o1, o2) -> genreMap.get(o2.getKey()) - genreMap.get(o1.getKey()))); // value 기준 내림차순 정렬

        // 5. 장르별 2곡씩 베스트앨범에 넣기
        for (Map.Entry<String, Integer> entry : entryList){
            String genre = entry.getKey();
            int cnt = 0; // 장르당 최대 2곡만 넣기
            for (Song song : songs) {
                if (song.getGenre().equals(genre)) {
                    if (cnt == 2) break; // 2곡이 차면 그만 넣고 나오기
                    list.add(song.getNum());
                    cnt++;
                }
            }
        }

        // 6. 리스트 -> 배열 변환
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int n : list) {
            answer[idx++] = n;
        }

        return answer;
    }
}
