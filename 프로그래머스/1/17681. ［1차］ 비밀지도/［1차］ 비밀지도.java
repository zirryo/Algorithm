class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(combined);

            StringBuilder sb = new StringBuilder();
            while (binary.length() < n) {
                binary = "0" + binary;
            }

            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}