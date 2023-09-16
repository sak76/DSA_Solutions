class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] suffixSum = new int[n];
        suffixSum[n-1] = shifts[n-1]%26;
        for(int i = n-2; i >= 0; i--) {
            suffixSum[i] = (shifts[i]%26 + suffixSum[i+1])%26;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int num = c - 'a';
            int finalNum = (suffixSum[i] + num)%26;
            char res = (char)('a' + finalNum);
            sb.append(res);
        }

        return sb.toString();
    }
}