class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s  :strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            map.computeIfAbsent(str,k->new ArrayList<>()).add(s);
        }
        return new ArrayList(map.values());
    }
}