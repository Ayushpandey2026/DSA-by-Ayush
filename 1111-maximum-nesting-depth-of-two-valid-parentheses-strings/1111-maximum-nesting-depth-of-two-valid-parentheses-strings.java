class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int depth = 0;
        int[] result = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                depth++;
                result[i] = depth % 2;
            } else {
                result[i] = depth % 2;
                depth--;
            }
        }
        return result;
    }
}