import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        Map<Integer, Integer> attackTime = new HashMap<>();
        int lastAttackTime = 0;
        
        for(int[] attack : attacks) {
            attackTime.put(attack[0], attack[1]);
            lastAttackTime = Math.max(lastAttackTime, attack[0]);
        }

        int curHealth = health;
        int successTime = 0;

        for (int curT = 1; curT <= lastAttackTime; curT++) {
            if (attackTime.containsKey(curT)) {
                int damage = attackTime.get(curT);
                curHealth -= damage;
                successTime = 0;

                if (curHealth <= 0) return -1;
            } 
            else {
                curHealth += x; 
                successTime++;   

                if (successTime == t) {
                    curHealth += y;
                    successTime = 0; 
                }
                
                if (curHealth > health) curHealth = health;
            }
        }
        return curHealth;
    }
}