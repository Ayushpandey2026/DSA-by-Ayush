class Solution {
    public class Envelop implements Comparable<Envelop>{
        int w; 
        int h;
      public Envelop(int w, int h){
            this.w =w;
            this.h=h;
        }
        public int compareTo(Envelop e){
            if(this.w==e.w) return e.h-this.h;
            return this.w - e.w;
        }

    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Envelop[] arr = new Envelop[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for(Envelop e: arr){
            int h=e.h;
            int idx = Collections.binarySearch(list,h);
            if(idx<0) idx = -(idx+1);
            if(idx==list.size()) list.add(h);
            else list.set(idx,h);
        }
        return list.size();
    }
}