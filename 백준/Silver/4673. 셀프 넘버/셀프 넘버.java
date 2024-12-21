public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int dn = d(i);
            if (dn <= 10000) {
                visited[dn] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
