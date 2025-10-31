class Solution {
    List<String> ans = new ArrayList<>();

    private void compute(String num, int target, int pos, String s, long currVal, long prevNum) {
        if (pos == num.length()) {
            if (currVal == target) ans.add(s);
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;

            String currStr = num.substring(pos, i + 1);
            long currNum = Long.parseLong(currStr);

            if (pos == 0) {
                compute(num, target, i + 1, currStr, currNum, currNum);
            } else {
               
                compute(num, target, i + 1, s + "+" + currStr, currVal + currNum, currNum);
               
                compute(num, target, i + 1, s + "-" + currStr, currVal - currNum, -currNum);
                compute(num, target, i + 1, s + "*" + currStr, currVal - prevNum + prevNum * currNum, prevNum * currNum);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        compute(num, target, 0, "", 0, 0);
        return ans;
    }
}
