import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int vLen = strToInt(video_len);
        int playPos = strToInt(pos);
        int opStart = strToInt(op_start);
        int opEnd = strToInt(op_end);
        
        if (playPos >= opStart && playPos < opEnd) {
                playPos = opEnd;
            }
        
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) {
                playPos = Math.max(0, playPos - 10);
            } else {
                playPos = Math.min(vLen, playPos + 10);
            }
            
            if (playPos >= opStart && playPos < opEnd) {
                playPos = opEnd;
            }
            
        }
        
        return intToStr(playPos);
    }
    private int strToInt(String timeStr) {
    String[] parts = timeStr.split(":");
    
    int mm = Integer.parseInt(parts[0]); 
    int ss = Integer.parseInt(parts[1]); 
    
    return mm * 60 + ss;
}
    private String intToStr(int timeInt) {
        int mm = timeInt / 60;
        int ss = timeInt % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
}