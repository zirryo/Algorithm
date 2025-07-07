import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> mod0 = new ArrayList<>();
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int mod = num % 3;
            if (mod == 0) mod0.add(num);
            else if (mod == 1) mod1.add(num);
            else mod2.add(num);
        }

        // 1 - mod0 없다면 mod1, mod2 단일 구성이어야 함
        if (mod0.isEmpty() && !mod1.isEmpty() && !mod2.isEmpty()) {
            System.out.println("-1");
            return;
        }

        // 2 - mod0이 2개 이상
        if (mod0.size() > 1 && (mod1.size() + mod2.size() < mod0.size() - 1)) {
            System.out.println("-1");
            return;
        }

        List<Integer> result = new ArrayList<>();

        if (mod0.isEmpty()) { // mod0이 없는 경우
            if (!mod1.isEmpty()) {
                result.addAll(mod1);
            } else {
                result.addAll(mod2);
            }
        } else { // mod0이 있는 경우
            PriorityQueue<Integer> m1 = new PriorityQueue<>(mod1);
            PriorityQueue<Integer> m2 = new PriorityQueue<>(mod2);
            PriorityQueue<Integer> m0 = new PriorityQueue<>(mod0);

            boolean lastIsMod1 = true;

            if (mod1.size() + mod2.size() != mod0.size() - 1) {
                if (!m1.isEmpty()) {
                    result.add(m1.poll());
                } else if (!m2.isEmpty()) {
                    result.add(m2.poll());
                    lastIsMod1 = false;
                }
            }

            while (true) {
                if (m0.size() == 1) {
                    if (lastIsMod1) {
                        result.addAll(m1);
                        m1.clear();
                    } else {
                        result.addAll(m2);
                        m2.clear();
                    }
                    result.add(m0.poll());
                } else if (m0.isEmpty()) {
                    result.addAll(m1);
                    result.addAll(m2);
                    break;
                } else {
                    result.add(m0.poll());
                    if (!m1.isEmpty()) {
                        result.add(m1.poll());
                        lastIsMod1 = true;
                    } else if (!m2.isEmpty()) {
                        result.add(m2.poll());
                        lastIsMod1 = false;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) sb.append(n).append(" ");
        System.out.println(sb);
    }
}
