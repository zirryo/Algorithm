import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for(int t : tangerine) {
            sizeMap.put(t, sizeMap.getOrDefault(t, 0) + 1);
        }

        List<Integer> sizeList = new ArrayList<>(sizeMap.keySet());
        Collections.sort(sizeList, (o1, o2) -> sizeMap.get(o2) - sizeMap.get(o1));
        // 각 사이즈별 수량을 기준으로 내림차순 정렬
        int idx = 0;
        while (k > 0) {
            k -= sizeMap.get(sizeList.get(idx)); // 가장 수량 많은 사이즈부터 확인
            answer++;
            idx++;
        }
        return answer;
    }
}