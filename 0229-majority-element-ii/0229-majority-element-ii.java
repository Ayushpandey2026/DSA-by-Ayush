class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int candidate1 =0; int cnt1=0;
        int candidate2=0; int cnt2=0;
        for(int num : nums){
           if(num==candidate1){
                cnt1++;
            }
            else if(num==candidate2){
                cnt2++;
            }
           else if(cnt1==0) {
                candidate1=num;
                cnt1=1;
            }
            else if(cnt2==0) {
                candidate2=num;
                cnt2=1;
            }
            else {
                cnt1--;
                cnt2--;
            }

        }
        cnt1=0;
        cnt2=0;
        for(int num : nums){
            if(num==candidate1) cnt1++;
            else if(num==candidate2) cnt2++;
        }

        if(cnt1>nums.length/3) list.add(candidate1);
        if(cnt2>nums.length/3) list.add(candidate2);

       
        return list;
    }
}