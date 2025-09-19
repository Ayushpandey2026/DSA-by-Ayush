class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int  i =0;i<n;i++){
            int curr = asteroids[i];
            while(!st.isEmpty() && st.peek()>0 && curr<0){
                if(st.peek()<-curr){
                    st.pop();

                }
                else if(st.peek()==-curr){
                    st.pop();
                    curr=0;
                    break;
                }
                else{
                    curr=0;
                    break;
                }
            }
             if(curr!=0){
                    st.push(curr);
                }
        }
        int[] res= new int[st.size()];
        for(int i =res.length-1;i>=0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}