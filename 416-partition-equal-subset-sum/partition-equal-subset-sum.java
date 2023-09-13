class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if((sum %2) != 0) {
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length][sum/2 + 1];
        return isSubsetSumEqualToTarget(nums, nums.length - 1, sum/2, memo);
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