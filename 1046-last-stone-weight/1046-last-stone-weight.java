class Solution {
    public int lastStoneWeight(int[] arr) {
        int n=arr.length;
        List<Integer> list = new ArrayList<>();
        for(int ele : arr){
            list.add(ele);
        }
        while(list.size()>1){
            Collections.sort(list);
            int y = list.remove(list.size()-1);
             int x = list.remove(list.size()-1);
             if(x!=y) list.add(y-x);
        }
        if(list.size()==0) return 0;
        else return list.get(0);
    }
}