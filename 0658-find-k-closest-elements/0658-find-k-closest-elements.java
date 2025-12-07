class Solution {
    public class Pair implements Comparable<Pair>{
        int diff;
        int ele;
        Pair(int diff,int ele){
            this.diff=diff;
            this.ele=ele;
        }
        public int compareTo(Pair p){
           if(this.diff == p.diff)  return this.ele - p.ele;
            return this.diff - p.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
    
        PriorityQueue<Pair> pq =new PriorityQueue<Pair>(Collections.reverseOrder());
        for(int ele : arr){
         int diff  = Math.abs(x-ele);
        pq.add(new Pair(diff,ele));
        if(pq.size()>k)  pq.remove();
        }
        List<Integer> list = new ArrayList<>();
        while(pq.size()>0){
            Pair p = pq.remove();
            list.add(p.ele);
        }
        Collections.sort(list);
        return list;
    }
}