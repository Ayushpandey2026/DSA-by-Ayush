class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) list.add(1);
            else  {
                 int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                 list.add(val);
            }
        }
         res.add(list);
        }
            return res;
    }
}