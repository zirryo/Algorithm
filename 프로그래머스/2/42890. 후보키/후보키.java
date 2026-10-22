import java.util.*;

class Solution {

    public int solution(String[][] relation) {
        int rows = relation.length;
        int cols = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();

        List<Integer>  bitmask = new ArrayList<>();
        for (int i = 1; i < (1 << cols); i++) {
             bitmask.add(i);
        }

        bitmask.sort((a, b) -> Integer.bitCount(a) - Integer.bitCount(b));

        for (int bit : bitmask) {
            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((key & bit) == key) {
                    isMinimal = false;
                    break;
                }
            }

            if (!isMinimal) {
                continue;
            }

            Set<String> set = new HashSet<>();
            for (int r = 0; r < rows; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < cols; c++) {
                    if ((bit & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append(" ");
                    }
                }
                set.add(sb.toString());
            }

            if (set.size() == rows) {
                candidateKeys.add(bit);
            }
        }

        return candidateKeys.size();
    }
}