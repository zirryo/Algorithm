class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } 
            else {
                String binary = "0" + Long.toBinaryString(x);
                char[] chars = binary.toCharArray();
                int lastZeroIdx = binary.lastIndexOf("0");
                chars[lastZeroIdx] = '1';
                chars[lastZeroIdx + 1] = '0';
                
                answer[i] = Long.parseLong(new String(chars), 2);
            }
        }
        
        return answer;
    }
}