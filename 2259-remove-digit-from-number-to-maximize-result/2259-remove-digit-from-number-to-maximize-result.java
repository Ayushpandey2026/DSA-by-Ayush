class Solution {
    public String removeDigit(String number, char digit) {
        String max="";

         for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == digit) {
                    String key =number.substring(0,i) + number.substring(i+1);

                    if(key.compareTo(max)>0) max=key;
                } 
         }
         return max;
    }
}