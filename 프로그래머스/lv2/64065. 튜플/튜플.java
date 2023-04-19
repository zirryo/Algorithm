import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>();
        s = s.substring(1);
        String[] arr = s.split("\\{");
        for(int i=1; i< arr.length; i++) {
            arr[i] = arr[i].substring(0, arr[i].length()-2);
            st = new StringTokenizer(arr[i], ",");
            while (st.hasMoreTokens()) {
                String j = st.nextToken();
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int[] ans = new int[keySet.size()];
        int idx = 0;
        for(String key : keySet) {
            ans[idx++] = Integer.parseInt(key);
        }
        return ans;
    }
}