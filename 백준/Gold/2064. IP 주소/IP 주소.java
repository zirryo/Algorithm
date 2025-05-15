import java.util.*;
import java.io.*;

public class Main {

    static int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res << 8) + Integer.parseInt(parts[i]);
        }
        return res;
    }

    static String intToIp(int x) {
        return String.format("%d.%d.%d.%d",
                (x >>> 24) & 255,
                (x >>> 16) & 255,
                (x >>> 8) & 255,
                x & 255);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ips = new int[n];

        for (int i = 0; i < n; i++) {
            ips[i] = ipToInt(br.readLine());
        }

        int minIp = ips[0], maxIp = ips[0];
        for (int i = 1; i < n; i++) {
            minIp = Math.min(minIp, ips[i]);
            maxIp = Math.max(maxIp, ips[i]);
        }

        int diff = minIp ^ maxIp;

        int prefixLen = 0;
        for (int i = 31; i >= 0; i--) {
            if ((diff & (1 << i)) != 0) break;
            prefixLen++;
        }

        int mask = (prefixLen == 0) ? 0 : (-1 << (32 - prefixLen));
        int network = ips[0] & mask;

        System.out.println(intToIp(network));
        System.out.println(intToIp(mask));
    }
}
