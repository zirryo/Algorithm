import java.util.*;

public class Main {
    static class Statement {
        Set<Integer> S;
        int B;
        Statement(Set<Integer> S, int B) {
            this.S = S;
            this.B = B;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int N = sc.nextInt();
        List<Statement> stmts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < M; j++) S.add(sc.nextInt());
            int B = sc.nextInt();
            stmts.add(new Statement(S, B));
        }

        List<Integer> candidates = new ArrayList<>();
        for (int suspect = 1; suspect <= N; suspect++) {
            if (isValid(suspect, stmts, N)) candidates.add(suspect);
        }

        if (candidates.isEmpty()) {
            System.out.println("swi");
        } else {
            for (int i = 0; i < candidates.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(candidates.get(i));
            }
        }
    }

    static boolean isValid(int suspect, List<Statement> stmts, int N) {
        for (int i = 0; i < N; i++) {
            Statement st = stmts.get(i);
            boolean inSet = st.S.contains(suspect);
            boolean truth = (st.B == 1 ? inSet : !inSet);

            if (i + 1 == suspect) {
                if (truth) return false;
            } else {
                if (!truth) return false;
            }
        }
        return true;
    }
}
