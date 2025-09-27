class StockSpanner {
        private List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int span =1;
        int i = list.size()-2;
        while(i>=0 && list.get(i)<=price ){
            span++;
            i--;
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */