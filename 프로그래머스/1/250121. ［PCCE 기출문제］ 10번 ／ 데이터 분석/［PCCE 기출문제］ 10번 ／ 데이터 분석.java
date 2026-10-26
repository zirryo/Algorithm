import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = getColumnIndex(ext);
        int sortIdx = getColumnIndex(sort_by);

        List<int[]> filteredList = new ArrayList<>();

        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filteredList.add(row);
            }
        }

        filteredList.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));

        int[][] answer = new int[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }

        return answer;
    }

    private int getColumnIndex(String col) {
        switch (col) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return -1;
        }
    }
}