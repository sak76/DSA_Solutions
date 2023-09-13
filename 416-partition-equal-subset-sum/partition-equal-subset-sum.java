class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if((sum %2) != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum/2 + 1];
        int n = nums.length;
        int k = sum/2;

        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for(int j = 0; j <= k; j++) {
            if(nums[0] == j) {
                dp[0][j] = true;
            } 
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                boolean take = false;
                if(nums[i] <= j) {
                    take =  dp[i - 1][j - nums[i]];
                }

                boolean notTake = dp[i - 1][j];

                dp[i][j] = (take | notTake);
            }
        }

        return dp[n-1][k]; 
    }

    private boolean isSubsetSumEqualToTarget(int[] nums, int index, int k, Boolean[][] memo) {
        if(k == 0) {
            return true;
        }

        if(index == 0) {
            return k == nums[0];
        }

        if(memo[index][k] != null) {
            return memo[index][k];
        }

        boolean take = false;
        if(nums[index] <= k) {
            take = isSubsetSumEqualToTarget(nums, index - 1, k - nums[index], memo);
        }

        boolean notTake = isSubsetSumEqualToTarget(nums, index - 1, k, memo);
        return memo[index][k] = (take | notTake);
    }
}