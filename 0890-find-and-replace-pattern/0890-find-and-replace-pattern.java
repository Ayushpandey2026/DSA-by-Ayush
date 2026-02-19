class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] wToP = new int[26];
        int[] pToW = new int[26];
        
        Arrays.fill(wToP, -1);
        Arrays.fill(pToW, -1);

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            if (wToP[w] == -1) wToP[w] = p;
            if (wToP[w] != p) return false;

            if (pToW[p] == -1) pToW[p] = w;
            if (pToW[p] != w) return false;
        }

        return true;
    }
}