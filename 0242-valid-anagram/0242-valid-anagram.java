class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m!=n) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1,c2)) return true;
        return false;
    }
}