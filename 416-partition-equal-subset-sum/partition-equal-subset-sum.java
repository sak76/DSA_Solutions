class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if((sum %2) != 0) {
            return false;
        }

        int n = nums.length;
        int k = sum/2;
        
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];
        prev[0] = true;
        curr[0] = true;
        if(nums[0] <= k) {
            prev[nums[0]] = true;
        }
        boolean[] temp;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                boolean take = false;
               
                if(nums[i] <= j) {
                    take =  prev[j - nums[i]];
                }

                boolean notTake = prev[j];
                curr[j] = (take | notTake);
            }
            temp = prev;
            prev = curr;
            curr = temp;
        }
       // System.out.println("curr = " + Arrays.toString(curr));
        return curr[k]; 
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