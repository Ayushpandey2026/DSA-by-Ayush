class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return backtrack(words, letterCount, score, 0);
    }

    private int backtrack(String[] words, int[] letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        int res = backtrack(words, letterCount, score, index + 1);
        int wordScore = 0;
        boolean canForm = true;
        String word = words[index];
        int[] used = new int[26];
        for (char ch : word.toCharArray()) {
            int c = ch - 'a';
            used[c]++;
            wordScore += score[c];
            if (used[c] > letterCount[c]) {
                canForm = false;
            }
        }

        if (canForm) {
            for (int i = 0; i < 26; i++) letterCount[i] -= used[i];  
            res = Math.max(res, wordScore + backtrack(words, letterCount, score, index + 1));
            
            for (int i = 0; i < 26; i++) letterCount[i] += used[i];
        }

        return res;
    }
}