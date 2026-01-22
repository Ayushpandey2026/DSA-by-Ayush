class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : tasks){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            int val =entry.getValue();
            if(val==1) return -1;
            cnt +=val/3;
           if(val%3!=0) cnt++;
        
        }
        return cnt;
    }
}