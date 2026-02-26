class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while (target > 1) { 
            if (maxDoubles == 0) {
                moves += (target - 1);
                break;
            }

            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;
                moves++;
            } else {
                target -= 1;
                moves++;
            }
        }

        return moves;
    }
}