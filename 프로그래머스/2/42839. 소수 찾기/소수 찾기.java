import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String numbers) {
        int n = numbers.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = numbers.charAt(i) - '0';
        }

        Set<Integer> numberSet = new HashSet<>();
        boolean[] visited = new boolean[n];

        generateNumbers(digits, visited, 0, numberSet);

        int primeCount = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private void generateNumbers(int[] digits, boolean[] visited, int currentNum, Set<Integer> numberSet) {
        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int nextNum = currentNum * 10 + digits[i];
                numberSet.add(nextNum);

                generateNumbers(digits, visited, nextNum, numberSet);
                visited[i] = false; 
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}