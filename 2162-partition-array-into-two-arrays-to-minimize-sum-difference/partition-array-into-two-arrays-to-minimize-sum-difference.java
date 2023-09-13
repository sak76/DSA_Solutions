class Solution {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

      //  System.out.println("sum = " + sum);

        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();

        
        int n = nums.length;

        generateSubsetSum(nums, 0, n/2-1, leftMap);
        generateSubsetSum(nums, n/2, n-1, rightMap);

        // System.out.println("rightMap = " + rightMap);
        // System.out.println("leftMap = " + leftMap);



        int k = sum/2;
        int res = Integer.MAX_VALUE;

        for(int len : leftMap.keySet()) {
            List<Integer> left = leftMap.get(len);
            List<Integer> right = rightMap.get(nums.length/2 - len);
           
            if(right != null) {
            // System.out.println("right = " + right);
            // System.out.println("left = " + left);
                Collections.sort(right);
                for(int num : left) {
                 //   System.out.println("num = " + num);
                    int target = (sum/2) - num;
                //  System.out.println("Target = " + (k - num));
                    int lb = findLowerBoundNumber(right, target);
                //   System.out.println("nearest possible number = " + lb);
                //  if((num + nearestPossibleNumber) <= sum/2) {
                    res = Math.min(res, Math.abs(sum - 2*(num + lb)));
                }
            }
        }
       
        return res;
    }

    private void generateSubsetSum(int[] nums, int left, int right, Map<Integer, List<Integer>> subsetSumMap) {
        int n = right - left + 1;
        for(int i = 0; i < (1 << n); i++) {
            int sum = 0;
            int len = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) >= 1) {
                    sum+=nums[left + j];
                    len++;
                }
            }
            // System.out.println("sum = " + sum);
            // System.out.println("len = " + len);
            subsetSumMap.computeIfAbsent(len, k -> new ArrayList<>()).add(sum);
        }
        //System.out.println("subsetSumMap = " + subsetSumMap);
    }

    private int findLowerBoundNumber(List<Integer> subsetSums, int target) {
        int low = 0;
        int high = subsetSums.size() - 1;
        int mid;
        int ans = high;

        while(low <= high) {
            mid = low + (high - low)/2;
            if(subsetSums.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return subsetSums.get(ans);
    }
}