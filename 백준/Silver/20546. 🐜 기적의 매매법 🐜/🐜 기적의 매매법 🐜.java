import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int initialMoney = Integer.parseInt(br.readLine());
        int[] stockPrices = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        int jMoney = initialMoney;
        int jStocks = 0;

        for (int i = 0; i < 14; i++) {
            if (jMoney >= stockPrices[i]) {
                int buyStocks = jMoney / stockPrices[i];
                jStocks += buyStocks;
                jMoney -= buyStocks * stockPrices[i];
            }
        }
        int jTotal = jMoney + jStocks * stockPrices[13];

        int sMoney = initialMoney;
        int sStocks = 0;
        int riseDays = 0, fallDays = 0;

        for (int i = 1; i < 14; i++) {
            if (stockPrices[i] > stockPrices[i - 1]) {
                riseDays++;
                fallDays = 0;
            } else if (stockPrices[i] < stockPrices[i - 1]) {
                fallDays++;
                riseDays = 0;
            } else {
                riseDays = 0;
                fallDays = 0;
            }

            // 3일 연속 하락 시 매수
            if (fallDays >= 3 && sMoney >= stockPrices[i]) {
                int buyStocks = sMoney / stockPrices[i];
                sStocks += buyStocks;
                sMoney -= buyStocks * stockPrices[i];
            }

            // 3일 연속 상승 시 매도
            if (riseDays >= 3 && sStocks > 0) {
                sMoney += sStocks * stockPrices[i];
                sStocks = 0;
            }
        }
        int sTotal = sMoney + sStocks * stockPrices[13];

        if (jTotal > sTotal) {
            System.out.println("BNP");
        } else if (jTotal < sTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
