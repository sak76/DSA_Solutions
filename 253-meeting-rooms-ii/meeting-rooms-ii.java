class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}