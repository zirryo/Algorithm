import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] occupied = new int[1500];
        
        for (String[] book : book_time) {
            int startTime = timeToMin(book[0]);
            int endTime = timeToMin(book[1]) + 10;
            
            occupied[startTime] += 1; 
            occupied[endTime] -= 1;   
        }
        
        int maxRooms = 0;
        int curRooms = 0;
        
        for (int i = 0; i < occupied.length; i++) {
            curRooms += occupied[i];
            maxRooms = Math.max(maxRooms, curRooms);
        }
        
        return maxRooms;
    }
    
    private int timeToMin(String timeStr) {
        String[] parts = timeStr.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}