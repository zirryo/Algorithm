import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            
            int nx = x;
            int ny = y;
            
            if (command == 'U') ny++;
            else if (command == 'D') ny--;
            else if (command == 'R') nx++;
            else if (command == 'L') nx--;
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String path1 = x + " " + y + " " + nx + " " + ny;
            String path2 = nx + " " + ny + " " + x + " " + y;
            
            if (x < nx || (x == nx && y < ny)) {
                visited.add(path1);
            } else {
                visited.add(path2);
            }
            
            x = nx;
            y = ny;
        }

        return visited.size();
    }
}