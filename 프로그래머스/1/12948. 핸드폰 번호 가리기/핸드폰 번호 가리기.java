class Solution {
    public String solution(String phone_number) {
        int masking = phone_number.length() - 4;
        
        return "*".repeat(masking) + phone_number.substring(masking);
    }
}