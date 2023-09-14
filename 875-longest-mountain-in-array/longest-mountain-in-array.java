class Solution {
    public int longestMountain(int[] arr) {
        int base = 0;
        int end = 0;
        int longestMountain = 0;
        while(base < arr.length) {
            end = base;
            if((end < arr.length - 1) && arr[end] < arr[end+1]) {
                 while(end < arr.length - 1 && arr[end] < arr[end+1]) {
                    end++;
                 }

                if((end < arr.length - 1) && (arr[end] > arr[end+1])) {
                    while(end < arr.length - 1 && arr[end] > arr[end+1]) {
                        end++;
                    }
                    longestMountain = Math.max(longestMountain, end - base + 1);
                }

            }

            base = Math.max(end,base+1);
        }

        return longestMountain;
    }
}