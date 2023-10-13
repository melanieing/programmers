import java.util.*;

// 17683. 방금그곡

class ThatSong17683 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = -1;
        m = replaceSharps(m);
        
        for (String musicinfo : musicinfos) {
            String[] strArr = musicinfo.split(",");
            // 시작 시각
            String[] startInfo = strArr[0].split(":");
            int st = Integer.parseInt(startInfo[0]) * 60 + Integer.parseInt(startInfo[1]);
            // 끝난 시각
            String end = strArr[1];
            String[] endInfo = strArr[1].split(":");
            int ed = Integer.parseInt(endInfo[0]) * 60 + Integer.parseInt(endInfo[1]);
            // 제목
            String title = strArr[2];
            // 원 멜로디 정보
            String melody = replaceSharps(strArr[3]);
            // 실제로 재생되는 멜로디 정보
            String fullMelody = padMelody(melody, ed - st);
            
            if (fullMelody.contains(m) && maxTime < ed - st) { // 기억하는 멜로디가 담겨있고 재생시간이 가장 길다면 
                answer = title;
                maxTime = ed - st;
            }
            
        }
                
        return maxTime != -1 ? answer : "(None)";
    }
    
    public String padMelody(String melody, int time) { // 원멜로디와 재생시간을 넣으면 실제 재생되는 멜로디를 반환
        StringBuilder sb = new StringBuilder();
        if (melody.length() < time) {
            sb.append(melody);
            for (int i = melody.length(); i <= time; i++) { 
                sb.append(melody.charAt(i % melody.length()));
            }
        } else {
            sb.append(melody.substring(0, time));
        }
        return sb.toString();
    }
    
    public String replaceSharps(String melody) { // 반음을 다른 알파벳으로 대체해서 반환
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        
        return melody;        
    }

}
