import java.util.*;

class Solution {
    String[] arr = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int ans = 0;
        recursion("", 0);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public void recursion(String s, int depth) {
        list.add(s);
        if(depth == 5) return;
        for(int i=0; i<5; i++) {
            recursion(s+arr[i], depth+1);
        }
    }
}
