class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        // int[] arr = new int[nums.length];
        for(int val : nums){
            pq.add(val);
            if(pq.size()  > k) pq.remove();
        }

        return pq.peek();

    }
}