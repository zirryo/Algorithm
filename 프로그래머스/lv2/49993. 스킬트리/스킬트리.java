import java.util.*;

class Solution {
    static Map<Integer, Integer> skillMap = new HashMap<>();
    boolean[] isChecked;
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        isChecked = getArr(skill);
        makeMap(skill);
        for(int i=0; i<skill_trees.length; i++) {
            if(canLearn(skill, skill_trees[i])) ans++;
        }
        return ans;
    }
    private boolean canLearn(String skill, String sTree) {
        boolean[] check = new boolean[26];
        check = isChecked.clone();
        boolean res = true;
        for(int i=0; i<sTree.length(); i++) {
            int cur = sTree.charAt(i) - 'A';
            if(!check[cur]) continue;
            int order = skillMap.get(cur);
            for(int j=0; j<order; j++) {
                if(check[skill.charAt(j) - 'A']) {
                    res = false;
                    break;
                }
            }
            check[cur] = false;
        }
        return res;
    }
    private boolean[] getArr(String skill) {
        boolean[] check = new boolean[26];
        for(int i=0; i<skill.length(); i++) {
            char c = skill.charAt(i);
            check[c - 'A'] = true;
        }
        return check;
    }
    private void makeMap(String skill) {
        for(int i=0; i<skill.length(); i++) {
            skillMap.put(skill.charAt(i) - 'A', i);
        }
    }
}