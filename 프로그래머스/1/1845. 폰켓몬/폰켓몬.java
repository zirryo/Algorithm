import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokemonTypes = new HashSet<>();
        
        for (int num : nums) {
            pokemonTypes.add(num);
        }
        
        int max = nums.length / 2;
        
        return Math.min(pokemonTypes.size(), max);
    }
}