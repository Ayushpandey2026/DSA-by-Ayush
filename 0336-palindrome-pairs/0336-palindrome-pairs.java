class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int len = word.length();

            for (int cut = 0; cut <= len; cut++) {

                String left = word.substring(0, cut);
                String right = word.substring(cut);
                if(isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();

                    if(map.containsKey(revRight) && map.get(revRight) != i) {
                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }

               
                if(cut != len && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
