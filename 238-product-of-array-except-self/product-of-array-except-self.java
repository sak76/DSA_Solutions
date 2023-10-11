class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        if(n == 1) {
            return ans;
        }

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] *nums[i];
            suffix[n - i - 1] = suffix[n - i] * nums[n - i - 1];
        }

        for(int i = 0 ; i < n ; i++) {
            if(i == 0) {
                ans[i] = suffix[i+1];
            }
            else if(i == n - 1) {
                ans[i] = prefix[i - 1];
            }
            else {
                ans[i] = prefix[i - 1] *suffix[i + 1];
            } 
        }
        return ans;
    }
}