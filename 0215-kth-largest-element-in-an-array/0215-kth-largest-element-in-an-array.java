class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        // int[] arr = new int[nums.length];
        for(int val : nums){
            pq.add(val);
        }

        for(int i=0;i<nums.length - k;i++){
            pq.remove();
        }
        return pq.peek();

    }
}