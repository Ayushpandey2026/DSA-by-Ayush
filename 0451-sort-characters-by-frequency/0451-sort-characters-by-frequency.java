class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        StringBuilder sb = new StringBuilder();
       for(Map.Entry<Character,Integer> entry : sortedEntries){
        char c= entry.getKey();
        int freq= entry.getValue();
        for(int i=0;i<freq;i++){
            sb.append(c);
        }
       }
        return sb.toString();
    }
}