class MinStack {
    Stack<Long> st = new Stack<>();
    long min=-1;
    public MinStack() {
        
    }
    
    public void push(int val) {
        long x =(long)val;
        if(st.size()==0) {
        st.push(x);
        min=x;
        }

       else if(x>=min){
            st.push(x);  
        }
      else if(min > x){
            st.push(2*x-min);
            min=x;
        }
    }
    
    public void pop() {
    if (!st.isEmpty()) {
        long top = st.pop();  // pop first
        if (top < min) {
            min = 2 * min - top;
        }
    }
}
    
    public int top() {
    if (st.isEmpty()) return -1;
    long top = st.peek();
    if (top >= min) return (int)top;
    else return (int)min;
}
    
    public int getMin() {
        if(st.size()==0) return -1;
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */