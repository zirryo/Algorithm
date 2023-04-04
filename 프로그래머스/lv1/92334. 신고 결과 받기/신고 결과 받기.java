import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> reportedID = new HashMap<>(); // key:신고당한사람, value:신고한사람
        Map<String, Integer> idIndex = new HashMap<>(); // key:id, value:id의 인덱스
        for(int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
        }
        for(int i = 0; i < report.length; i++) {
            String[] cur = report[i].split(" ");
            reportedID.computeIfAbsent(cur[1], k1 -> new HashSet<>());
            reportedID.get(cur[1]).add(cur[0]);
        }
        for(int i = 0; i < id_list.length; i++) {
            Set<String> reporter = reportedID.get(id_list[i]);
            if(reporter != null && reporter.size() >= k) { // 회원 정지
                for(String s : reporter) {
                    answer[idIndex.get(s)]++;
                }
            }
        }
        return answer;
    }
}