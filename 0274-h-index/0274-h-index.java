class Solution {
    public int hIndex(int[] citations) {
          Arrays.sort(citations);
          int n = citations.length; int s =0;

          for(int i = 0;i < n; i++)
{              s = n-i;
            if(citations[i] >= s){
               return s;
            }
}
            return 0;
    }
}