import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();
    Map<String, Integer> menu;
    public String[] solution(String[] orders, int[] course) {  
        for(int i=0; i<course.length; i++) {
            menu = new HashMap<>();
            for(int j=0; j<orders.length; j++) {
                if(course[i] > orders[j].length()) continue;
                char[] charList = orders[j].toCharArray();
                Arrays.sort(charList);
                combi(0, course[i], new boolean[orders[j].length()], charList);
            }
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(menu.entrySet());
            entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // 내림차순
            int max = 0;
            for(Map.Entry<String, Integer> ent : entries) {
                int val = ent.getValue();
                if(val >= 2 && max <= val) {
                    max = val;
                    ans.add(ent.getKey());
                }
            }
        } 
        String[] answer = ans.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
    private void combi(int idx, int depth, boolean[] visited, char[] cl) {
        if(depth == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) sb.append(cl[i]);
            } 
            String s = sb.toString();
            menu.put(s, menu.getOrDefault(s, 0) + 1);
        } else {
            for(int i=idx; i<visited.length; i++) {
                visited[i] = true;
                combi(i+1, depth-1, visited, cl);
                visited[i] = false;
            }
        }
    }
}