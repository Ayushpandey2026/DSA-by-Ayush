class Solution {
    public String removeSubstring(String s, int k) {
        int n=s.length();
        Stack<int[]>  st = new Stack<>();
        for(char c :s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==c) st.peek()[1]++;
             else st.push(new int[]{c,1});

          if(st.size()>=2){
            int[] top = st.pop();
            int[] prev = st.pop();

            if(prev[0]=='(' && top[0]==')' && prev[1]>=k && top[1]>=k){

                prev[1] -=k;
                top[1] -=k;

                if(prev[1]>0) st.push(prev);
                if(top[1]>0) st.push(top);
            } 
            else{
            st.push(prev);
            st.push(top);
            }
          }
        }

          StringBuilder sb = new StringBuilder();
          for(int[] pair :st){
            char ch =(char)pair[0];
            int cnt = pair[1];
            for(int i=0;i<cnt;i++){
                sb.append(ch);
            } 
          }
        return sb.toString();
    }
}