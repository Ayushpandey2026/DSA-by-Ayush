class Solution {
    public class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele,int freq){
            this.ele= ele;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        PriorityQueue<Pair> pq =new PriorityQueue<Pair>();
        for(int ele : map.keySet()){
            int freq =map.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size()> k) pq.remove();
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            Pair p = pq.remove();
            arr[i] = p.ele;
        }
        return arr;


    }
}