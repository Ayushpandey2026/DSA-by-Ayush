class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int partLen = part.length();

        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));

            if(sb.length() >= partLen){
                if (sb.substring(sb.length() - partLen).equals(part)){
                    sb.delete(sb.length() - partLen, sb.length());
                }
            }
        }

        return sb.toString();
    }
}