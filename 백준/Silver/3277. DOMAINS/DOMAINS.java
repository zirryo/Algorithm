import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Map<String, Integer> domainCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String url = sc.nextLine().trim();

            if (url.startsWith("http://")) {
                url = url.substring(7);
            }

            int slashIndex = url.indexOf('/');
            String host = slashIndex != -1 ? url.substring(0, slashIndex) : url;

            String[] parts = host.split("\\.");
            String domain = parts[parts.length - 1];

            domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
        }

        int max = Collections.max(domainCount.values());

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        
        System.out.println(max);
        System.out.println(String.join(" ", result));
    }
}
