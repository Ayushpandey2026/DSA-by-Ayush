class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt=1;
        String add =a;
        while(a.length()<=10000){
            if(a.contains(b)) return cnt;
            cnt++;
            a +=add;
        }
        return -1;
    }
}