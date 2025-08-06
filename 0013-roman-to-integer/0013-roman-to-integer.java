class Solution {
    public int romanToInt(String s) {
        int n = s.length(); int sum=0; char d =' ';
        for(int i=0;i<n;i++){
            char c =s.charAt(i);
           if(i<n-1)  d =s.charAt(i+1);

            if(c=='M') sum+=1000;
            if(c == 'D') sum+=500;
            if(c=='L') sum+=50;
            if(c=='V') sum+=5;
            if(c=='C') {
                if(d == 'D') {
                    sum+= 400;
                    i++;
                }
                else if(d == 'M'){
                 sum+= 900;
                 i++;
                }
                else sum+=100;
            }
            else  if(c=='X') {
                if(d == 'L') {
                    sum+= 40;
                    i++;
                }
                else if(d == 'C'){
                 sum+= 90;
                 i++;
                }
                else sum+=10;
            }
            else  if(c=='I') {
                if(d == 'V') {
                    sum+= 4;
                    i++;
                }
                else if(d == 'X'){
                 sum+= 9;
                 i++;
                }
                else sum+=1;
            }
        }
        return sum;
    }
}