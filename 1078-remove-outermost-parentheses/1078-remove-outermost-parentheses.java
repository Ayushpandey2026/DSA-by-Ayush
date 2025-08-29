class Solution {
    public String removeOuterParentheses(String s) {
        int i=0,j=0;
        int n= s.length(); int cnt=0; String str = "";
       while(j<n){
            if(s.charAt(j) == '(') cnt++;
            else if(s.charAt(j)==')'){
                cnt--;
                if(cnt==0){
                    for(int k=i+1;k<j;k++){
                        str += s.charAt(k);
                    }
                    
                    i=j+1;
                }
            
            }
            j++;
       }
       return str;
    }
}