class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,high=n-1;
        int first=-1;
                    List<Integer> li=new ArrayList<>();

        while(l<=high){
            int mid=l+(high-l)/2;
            
                if(nums[mid]>target){
                    high=mid-1;
                }
                else if(nums[mid]<target){
                    l=mid+1;
                }
                else  {
                    first=mid;
                    high=mid-1;
                }
        }
                 
        
      
         if (first == -1) {
            return li;
        
       }
        for (int i = first; i < nums.length; i++) {
            if (nums[i] == target) {
                li.add(i);  
            } 
            else {
                break; 
            }
        }
              
        
        return li;
    }
}