import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            int[] nums = new int[n];
            int[] parentIdx = new int[n];
            int[] depth = new int[n];
            int targetIdx = -1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] == k) targetIdx = i;
            }

            parentIdx[0] = -1;
            depth[0] = 0;

            int pIdx = -1;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    pIdx++;
                }
                parentIdx[i] = pIdx;
                depth[i] = depth[pIdx] + 1;
            }

            int count = 0;
            int targetParentIdx = parentIdx[targetIdx];

            for (int i = 0; i < n; i++) {
                if (i == targetIdx) continue;

                int myParentIdx = parentIdx[i];

                if (myParentIdx > 0 && targetParentIdx > 0 && myParentIdx != targetParentIdx
                        && parentIdx[myParentIdx] == parentIdx[targetParentIdx]) {
                    count++;
                }

                if (depth[i] > depth[targetIdx]) break;
            }
            System.out.println(count);
        }
    }
}