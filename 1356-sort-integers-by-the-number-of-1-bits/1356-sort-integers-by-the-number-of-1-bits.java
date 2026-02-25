class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArray[i] = arr[i];
        }

        Arrays.sort(boxedArray, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            }
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArray[i];
        }
        
        return arr;
    }
}