class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>(); 
        Stack<Integer> st = new Stack<>();

        for(int num : nums2){
            while(!st.isEmpty() && st.peek()<num){
                map.put(st.pop(),num);
            }
            st.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            arr[i] = map.getOrDefault(nums1[i],-1);
        }
        return arr;

    }
}