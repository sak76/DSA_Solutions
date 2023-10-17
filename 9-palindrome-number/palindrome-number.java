class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int reversedNum = 0;
        int n = x;
        while(n != 0) {
            int r = n%10;
            if((long)(reversedNum *10 + r) > Integer.MAX_VALUE) {
                return false;
            }
            reversedNum = reversedNum*10 + r;
            n = n/10;
        }

        return reversedNum == x;
    }
}